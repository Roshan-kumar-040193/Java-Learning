package org.example;

//thenCompose - used when return type of a function is completable future i.e. when we want to pass a completable future down the chain
//theCombine - used to combine result of 2 Async tasks

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class ThenComposeAndThenCombine {
    TaskResult task(String taskName,int sec){
        TaskResult t=new TaskResult(sec,taskName);
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    public void runTask() throws ExecutionException, InterruptedException {
        Supplier<TaskResult> s1=()->task("task1",3000);
        Supplier<TaskResult> s2=()->task("task2",4000);
        Supplier<TaskResult> s3=()->task("task3",5000);
        Supplier<TaskResult> s4=()->task("task4",6000);

        CompletableFuture.supplyAsync(s1).
                thenCombine(CompletableFuture.supplyAsync(s2),(r1,r2)->combine(r1,r2))
                .thenCompose(res->{
                    var future3 = CompletableFuture.supplyAsync(s3);
                    var future4 = CompletableFuture.supplyAsync(s4);
                    var future5 = future3.thenCombine(future4,(r3,r4)->combine(r3,r4));
                    return res.thenCombine(future5.thenCompose(resp->resp),(r3,r4)->r3+" "+r4);
                }).thenAccept(result->System.out.println(result)).get();
    }

    CompletableFuture<String> combine(TaskResult s1,TaskResult s2){
        return CompletableFuture.supplyAsync(()->s1.toString()+"  "+s2.toString());
    }


}
class TaskResult{
    int time;
    String message;
    TaskResult(int time,String messaga){
        this.time = time;
        this.message = messaga;
    }

    @Override
    public String toString() {
        return "TaskResult{" +
                "time=" + time +
                ", message='" + message + '\'' +
                '}';
    }
}

