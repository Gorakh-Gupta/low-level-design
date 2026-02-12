package com.gorakh.lldrunner.distributedtaskscheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerNode {
    private final String nodeId;
    private final int cpu;
    private final int memory;
    private final int processingSpeed;
    private  int totalCpu;
    private int totalMemory;
    private WorkerNodeStatus workerStatus;
    private final ExecutorService executor;


    public WorkerNode(String nodeId, int cpu, int memory, int processingSpeed) {
        this.nodeId = nodeId;
        this.cpu = cpu;
        this.memory = memory;
        this.processingSpeed = processingSpeed;
        this.totalCpu = cpu;
        this.totalMemory = memory;
        this.workerStatus = WorkerNodeStatus.ACTIVE;
        this.executor = Executors.newCachedThreadPool();
    }



    public String getNodeId() {
        return nodeId;
    }

    public int getProcessingSpeed() {
        return processingSpeed;
    }

    public int getTotalCpu() {
        return totalCpu;
    }

    public int getTotalMemory() {
        return totalMemory;
    }

    public WorkerNodeStatus getWorkerStatus() {
        return workerStatus;
    }

    public void setWorkerStatus(WorkerNodeStatus workerStatus) {
        this.workerStatus = workerStatus;
    }

    public ExecutorService getExecutor() {
        return executor;
    }


    // can Run
    public boolean canRun(Task task) {
        return workerStatus == WorkerNodeStatus.ACTIVE &&
                totalMemory >= task.getMemory() &&
                totalCpu >= task.getCpu();
    }

    // assign task
    public synchronized void allocate(Task task) {
        totalMemory -= task.getMemory();
        totalCpu -= task.getCpu();
    }

    // release task
    public synchronized  void release(Task task) {
        totalMemory +=  task.getMemory();
        totalCpu += task.getCpu();
    }


}
