package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableExampleWIthExecutor {

    public void testing(){
        //runnable has no return type and we can't throw checked exception
        //the below is a task which we can run asynchronously
        Runnable r1=() -> {
            System.out.println("Inside runnable1 for current thread "+Thread.currentThread().toString());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Exiting runnable1 for current thread "+Thread.currentThread().toString());
        };


        Runnable r2=() -> {
            System.out.println("Inside runnable2 for current thread "+Thread.currentThread().toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Exiting runnable2 for current thread "+Thread.currentThread().toString());
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



