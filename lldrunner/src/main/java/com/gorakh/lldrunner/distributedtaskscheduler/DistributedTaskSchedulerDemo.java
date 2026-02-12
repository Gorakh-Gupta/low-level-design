package com.gorakh.lldrunner.distributedtaskscheduler;

import java.util.ArrayList;
import java.util.List;

public class DistributedTaskSchedulerDemo {
    public static void run() throws InterruptedException {
        Scheduler scheduler = Scheduler.getInstance();


	// Test case 1
//
//		scheduler.registerWorker(new WorkerNode(  "W1",  4, 16,  5 ));
//		scheduler.registerWorker(new WorkerNode( "W2",  8, 32,  10 ));
//		scheduler.listWorkers();

	// test case 2
//		scheduler.registerWorker(new WorkerNode(  "W1",  4, 16,  5 ));
//		scheduler.registerWorker(new WorkerNode( "W2",  8, 32,  10 ));
//
//		scheduler.submitTask(List.of(
//				new Task("T1",2,8,1,TaskPriority.LOW),
//				new Task("T2",4,16,2, TaskPriority.LOW)
//		));
//
//        Thread.sleep(100);
//		scheduler.listTasks();
//        Thread.sleep(2000);
//        scheduler.listTasks();
//


     // test case 3
//		scheduler.registerWorker(new WorkerNode("W1",4,16,5));
//		scheduler.submitTask(List.of(new Task("T1",2,4,1,TaskPriority.LOW)));
//		Thread.sleep(10);
//		Thread.sleep(1000);
//		scheduler.listTasks();
//

        // test case 4
//        scheduler.registerWorker(new WorkerNode("W1",2,8,5));
//        scheduler.submitTask(List.of(
//                new Task("T1",2,4,10,TaskPriority.LOW),
//                new Task("T2",4,16,5, TaskPriority.LOW)
//        ));
//        Thread.sleep(10);
//        Thread.sleep(10000);
//        scheduler.listTasks();
//
        //test case 5

//        scheduler.registerWorker(new WorkerNode(  "W1",  6, 32,  5 ));
//        scheduler.registerWorker(new WorkerNode( "W2",  8, 32,  10 ));
//
//        scheduler.submitTask(List.of(
//                new Task("T1",2,8,1,TaskPriority.LOW),
//                new Task("T2",4,16,2, TaskPriority.LOW)
//        ));
//        scheduler.listTasks();
//
//        Thread.sleep(100);
//        scheduler.simulateWorkerFailure("W2");
//
//        scheduler.listTasks();
//        scheduler.listWorkers();

        //test case 6
//		scheduler.registerWorker(new WorkerNode("W1", 2, 16, 5));
//		scheduler.submitTask(List.of(
//				new Task("T1", 2, 4, 10, TaskPriority.HIGH),
//				new Task("T2", 2,4, 5, TaskPriority.LOW)
//		));
//
//		Thread.sleep(10); // time to task get assigned to worker nodes
//		scheduler.listTasks();


        //test case 7
//        scheduler.registerWorker(new WorkerNode("W1", 2, 8, 5));
//		scheduler.submitTask(List.of(
//				new Task("T1", 2, 4, 10, TaskPriority.HIGH),
//				new Task("T2", 2,4, 5, TaskPriority.LOW)
//		));
//        scheduler.listTasks();
//
//       // Simulate auto-scaling to register a new worker
//        scheduler.autoscale();
//        scheduler.listTasks();
//        scheduler.listWorkers();

        //test case 8
//		scheduler.registerWorker(new WorkerNode("W1", 2, 16, 5));
//		scheduler.submitTask(List.of(
//				new Task("T1", 2, 4, 10, TaskPriority.LOW),
//				new Task("T2", 2,4, 10, TaskPriority.LOW)
//		));
//        scheduler.listTasks();
//        Thread.sleep(100);
//        scheduler.simulateTimeOut("T1",13);
//        Thread.sleep(100);
//        scheduler.listTasks();


        //test case 9
//        scheduler.registerWorker(new WorkerNode("W1", 4, 16, 5));
//        Task task = new Task("T1", 2, 4, 10, TaskPriority.LOW);
//        scheduler.submitTask(List.of(
//                task
//        ));
//        scheduler.listTasks();
//        Thread.sleep(100);
//
//        scheduler.cancelTask(task);
//        scheduler.listTasks();


        //test case 10
//        scheduler.registerWorker(new WorkerNode("W1", 4, 16, 5));
//        scheduler.submitTask(List.of(
//                new Task("T1", 2, 4, 10, TaskPriority.LOW),
//                new Task("T2", 2,4, 5, TaskPriority.LOW)
//        ));
//        Thread.sleep(100);
//        scheduler.listTasks();

        //test case 11
        scheduler.registerWorker(new WorkerNode("W1", 4, 16, 5));
        scheduler.registerWorker(new WorkerNode("W2", 8, 32, 10));
        scheduler.submitTask(List.of(
                new Task("T1", 2, 8, 10, TaskPriority.LOW),
                new Task("T2", 4,16, 20, TaskPriority.LOW)
        ));
        Thread.sleep(100);
        scheduler.listTasks();

        Thread.sleep(12000);
		scheduler.simulateWorkerFailure("W2");
		scheduler.listWorkers();
		scheduler.listTasks();

    }
}
