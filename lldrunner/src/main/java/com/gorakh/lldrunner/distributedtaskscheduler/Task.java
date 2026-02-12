package com.gorakh.lldrunner.distributedtaskscheduler;

import java.time.LocalDateTime;

public class Task {
    private final String taskId;
    private final int cpu;
    private final int memory;
    private final int executionTime;
    private final TaskPriority taskPriorty;
    private TaskStatus taskStatus;
    private WorkerNode assignedWorker;
    private Long starttime;

    public Task(String taskId, int cpu, int memory, int executionTime, TaskPriority taskPeriorty) {
        this.taskId = taskId;
        this.cpu = cpu;
        this.memory = memory;
        this.executionTime = executionTime;
        this.taskPriorty = taskPeriorty;
        this.taskStatus = TaskStatus.QUEUED;
        this.assignedWorker = null;
    }

    public String getTaskId() {
        return taskId;
    }

    public int getCpu() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public TaskPriority getTaskPriorty() {
        return taskPriorty;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public WorkerNode getAssignedWorker() {
        return assignedWorker;
    }

    public void setAssignedWorker(WorkerNode assignedWorker) {
        this.assignedWorker = assignedWorker;
    }

    public Long getStarttime() {
        return starttime;
    }

    public void setStarttime(Long starttime) {
        this.starttime = starttime;
    }
}
