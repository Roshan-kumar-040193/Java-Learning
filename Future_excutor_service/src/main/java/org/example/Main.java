package org.example;

//Asynchronous Execution:
//
//Tasks submitted to an ExecutorService are executed asynchronously, meaning that when you submit a task, the calling thread (e.g., the main thread) does not wait for the task to complete before continuing.
//This allows the main thread to perform other operations while the task is being executed in a separate thread.


//Parallel Execution:
//
//Parallel execution refers to multiple tasks running at the same time on separate threads. Whether tasks can run in parallel depends on the number of threads available in the thread pool.
//If the ExecutorService is configured with multiple threads, it can run multiple tasks simultaneously (in parallel). If it’s a single-threaded executor, tasks will be executed one after the other (not in parallel).


import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("pre RunnableExampleWIthExecutor");
//        RunnableExampleWIthExecutor r = new RunnableExampleWIthExecutor();
//        r.testing();
//        ExecutionCompletionServiceExample executionCompletionServiceExample = new ExecutionCompletionServiceExample();
//        executionCompletionServiceExample.tesing();

        BasicCompletableFutureExample cfe = new BasicCompletableFutureExample();
        cfe.testing();
        Thread.sleep(1000);
        System.out.println("post RunnableExampleWIthExecutor");//this executes before


    }
}
