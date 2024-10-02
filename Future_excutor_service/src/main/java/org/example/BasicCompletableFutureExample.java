package org.example;


//Noraml future has the below limitation
//can not create a asynchronous pipeline
//can not complete a future

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class BasicCompletableFutureExample {

    public void testing(){

        System.out.println("Inside testing");

        Supplier<Integer> s1=()->task(5000,"task1");
        Supplier<Integer> s2=()->task(3000,"task1");

        CompletableFuture.supplyAsync(s1)
                .thenCombine(CompletableFuture.supplyAsync(s2),(r1,r2)->(Integer)r1+(Integer) r2)
                .thenApply(data->data+"::Handled Apply with current thread info "+Thread.currentThread().toString())
                .thenAccept(data -> System.out.println(data+" :: handled accept with current thread info "+Thread.currentThread().toString()));

        System.out.println("outside completable future");
    }

    public int task(int t, String tsk){
        System.out.println("started task: "+tsk+" which will wait for "+t+" sec for thread"+Thread.currentThread().toString());
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task: "+tsk+" completed");
        return t;
    }


}
