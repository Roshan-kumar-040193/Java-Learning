package org.example;

import java.util.concurrent.*;

public class CallableExampleWithExcutores {
    public void testing(){
        //From callable we can return a data and we can throw checked exception
        //the below is a task which we can run asynchronously
        Callable r1=() -> {
            System.out.println("Inside runnable1 for current thread "+Thread.currentThread().toString());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Exiting runnable1 for current thread "+Thread.currentThread().toString());
            return "Task 1";
        };


        Callable r2=() -> {
            System.out.println("Inside runnable1 for current thread "+Thread.currentThread().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Exiting runnable1 for current thread "+Thread.currentThread().toString());
            return "task2";
        };

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        //this will create a single thread for execution of tasks
//        //so at 1 moment ony 1 thread will be able to execute

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //here 3 threads are running picking each task and then running them parallely

        Future f1= executorService.submit(r1); // Submit first task
        Future f2 = executorService.submit(r2); // Submit second task4

        try {
            f1.get();//this blocks the flow and until we get the response back from f1.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("after f1.get() is completed this block is called");
        executorService.shutdown(); // Shutdown the executor after tasks are submitted
    }
}
