package com.gorakh.lldrunner.distributedtaskscheduler;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Scheduler {

    private static Scheduler instance;
    private final Map<String, WorkerNode>workers;
    private final Map<String, Task> tasks;

    PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparing((Task t) -> t.getTaskPriorty()).reversed());

    public Scheduler() {
        this.workers = new ConcurrentHashMap<>();
        this.tasks = new ConcurrentHashMap<>();
    }
    public static synchronized Scheduler getInstance(){
        if(instance == null){
            instance = new Scheduler();
        }
        return instance;
    }

    // Register worker
    public void registerWorker(WorkerNode w) {
        workers.put(w.getNodeId(), w);
        schedule();
    }

    // submit task
    public synchronized void submitTask(List<Task> taskss){
        for(Task t : taskss){
            tasks.put(t.getTaskId(), t);
            taskQueue.offer(t);
        }
        schedule();
    }

    synchronized void schedule() {
      Iterator<Task> iterator = taskQueue.iterator();
      while(iterator.hasNext()){
        Task task = iterator.next();
        WorkerNode worker = findBestWorker(task);
        if(worker == null)continue;
        iterator.remove();
        assign(worker, task);
      }
    }

    // find optimal worker
    private synchronized  WorkerNode findBestWorker(Task task) {
        return workers.values().stream()
                .filter(w -> w.canRun(task))
                .max(Comparator.comparing(w -> w.getProcessingSpeed()))
                .orElse(null);
    }

    //assign task
    private synchronized  void assign(WorkerNode worker, Task task) {
        worker.allocate(task);
        task.setTaskStatus(TaskStatus.ASSIGNED);
        task.setAssignedWorker(worker);
        worker.getExecutor().submit(new TaskExecutor(task, worker,this));
    }


    public void listTasks() {
        if(tasks.isEmpty()){
            System.out.println("NO tasks Available");
        }
        tasks.values().forEach(t ->
                System.out.println( "taskId: " + t.getTaskId() + ", status: " + t.getTaskStatus() + ", assignedTo: "+ (t.getAssignedWorker() != null ? t.getAssignedWorker().getNodeId() : "No Worker Assigned")));
    }

    public void listWorkers() {
        if(workers.isEmpty()){
            System.out.println("NO Worker Available");
        }
        workers.values().forEach(w ->
                System.out.println( "nodeId:" + w.getNodeId() + ", cpu: " +  w.getTotalCpu() + ", memory: " + w.getTotalMemory() + ", speed: " + w.getProcessingSpeed() + ", status: " + w.getWorkerStatus() ));

    }

    //complete task
    public synchronized void completeTask(WorkerNode worker, Task task) {
        task.setTaskStatus(TaskStatus.COMPLETED);
        worker.release(task);
        schedule();
    }

    //requeue
    public void requeueTask(Task task) {
        WorkerNode worker = task.getAssignedWorker();
        task.setTaskStatus(TaskStatus.QUEUED);
        worker.release(task);
        task.setAssignedWorker(null);
        taskQueue.offer(task);
        schedule();
    }

    //cancel task
    public synchronized  void cancelTask(Task task) {
        WorkerNode worker = task.getAssignedWorker();
        if(worker != null)
            worker.release(task);
        task.setTaskStatus(TaskStatus.CANCELLED);
    }


    // reset scheduler
    public void resetscheduler(){
        workers.clear();
        tasks.clear();
    }


    //simulate worker failure
    public void simulateWorkerFailure(String workerId) {
        WorkerNode worker = workers.get(workerId);
        worker.setWorkerStatus(WorkerNodeStatus.INACTIVE);
//        workers.remove(workerId);

        tasks.values().stream()
                .filter(t -> workerId.equals(t.getAssignedWorker().getNodeId()) && t.getTaskStatus() != TaskStatus.COMPLETED)
                .forEach(this::requeueTask);
    }

    //simulate timeout
    public void simulateTimeOut(String taskId, int actualTime) {
        Task task = tasks.get(taskId);
        WorkerNode worker = task.getAssignedWorker();
        worker.release(task);
        if (task.getStarttime() != null &&
                actualTime > task.getStarttime() * 1.2) {
            requeueTask(task);
            worker.release(task);
            schedule();
        }
    }


    /* Auto Scaling */
    public void autoscale() {
        int requireCpu = 0;
        int reuiredMemory = 0;
        Iterator<Task> iterator = taskQueue.iterator();
        while(iterator.hasNext()){
            Task t = iterator.next();
            requireCpu += t.getCpu();
            reuiredMemory += t.getMemory();
        }
        registerWorker(new WorkerNode("W" + (workers.size() + 1), requireCpu, reuiredMemory, 10));
        schedule();
    }


}
