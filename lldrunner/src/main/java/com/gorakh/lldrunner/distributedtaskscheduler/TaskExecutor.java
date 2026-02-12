package com.gorakh.lldrunner.distributedtaskscheduler;

import java.time.LocalDateTime;

public class TaskExecutor implements Runnable{
    private final Task task;
    private final WorkerNode worker;
    private final Scheduler scheduler;

    public TaskExecutor(Task task, WorkerNode worker, Scheduler scheduler) {
        this.task = task;
        this.worker = worker;
        this.scheduler = scheduler;
    }


    @Override
    public void run() {
        try{
//            task.setTaskStatus(TaskStatus.RUNNING);
            task.setStarttime(System.currentTimeMillis());
//            System.out.println("running started "+ System.currentTimeMillis());
            Thread.sleep(task.getExecutionTime() * 1000L);
            scheduler.completeTask(worker, task);
        }
        catch (Exception e){
            scheduler.requeueTask(task);
            System.out.println(e.fillInStackTrace());
        }
    }
}
