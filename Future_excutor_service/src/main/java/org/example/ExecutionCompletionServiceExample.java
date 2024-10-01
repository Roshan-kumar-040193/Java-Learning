package org.example;

import java.util.concurrent.*;

public class ExecutionCompletionServiceExample {

    public void tesing() throws ExecutionException, InterruptedException {
        Callable<String> c1=()-> task("task1",10000);
        Callable<String> c2=()-> task("task2",1000);
        Callable<String> c3=()-> task("task3",2000);
        Callable<String> c4=()-> task("task4",3000);
        Callable<String> c5=()-> task("task5",4000);


        ExecutorService e= Executors.newFixedThreadPool(3);

        ExecutorCompletionService ecs = new ExecutorCompletionService<>(e); //it's a decorator on the executor service

        Future f1= ecs.submit(c1);
        Future f2= ecs.submit(c2);
        Future f3= ecs.submit(c3);
        Future f4= ecs.submit(c4);
        Future f5= ecs.submit(c5);

//        System.out.println(f1.get()); //the get mthod will again wait for the first one to complete then only it allows the below methods to run
//        System.out.println(f2.get()); //even if the task is completed by it's individual thread this print will have to wait
//        System.out.println(f3.get());
//        System.out.println(f4.get());
//        System.out.println(f5.get());

        //to resolve the above issue executorCompletaionService provides a method called take, what it does it waits until we have a response from
        //the service and returns the corresponding future then again goes into waiting state till we get another response

        for(int i=0;i<5;i++){
            Future f = ecs.take();
            if(f==f1){
                System.out.println("f1 get"+f1.get());
            }
            else if(f==f2){
                System.out.println("f2 get"+f2.get());
            }
            else if(f==f3){
                System.out.println("f3 get"+f3.get());
            }
            else if(f==f4){
                System.out.println("f4 get"+f4.get());
            }
            else if(f==f5){
                System.out.println("f5 get"+f5.get());
            }
            else{
                System.out.println("Something went wrong");
            }
        }

        e.shutdown();


    }


    public String task(String s,int t){
            System.out.println("Inside task " + t +" for current thread "+Thread.currentThread().toString());
            try {
                Thread.sleep(t);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Exiting task "+t+" for current thread "+Thread.currentThread().toString());
            return s;
    }
}
