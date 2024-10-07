package com.example.kafka.KafkaProducer.Controller;

import com.example.kafka.KafkaProducer.Service.PublishMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class PublishController {

    @Autowired
    PublishMessage publish;

    @GetMapping("/publish/{message}")
    public CompletableFuture<String> publishMessage(@PathVariable String message) {
        // Using CompletableFuture to run the message publishing loop asynchronously
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            int i = 0;
            while (i < 10000) {
                publish.publishMessage(message + " : " + i);
                i++;
            }

            // Simulate long-running task
            return task();
        }).whenComplete((result, exception) -> {
            if (exception != null) {
                // Log the error or handle the exception
                System.out.println("Error occurred: " + exception.getMessage());
            }
        });

        // Returning CompletableFuture in ResponseEntity
        return future;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        // Return a simple "pong" response
        return ResponseEntity.ok("pong");
    }

    public String task(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "hi after 2 mins";
    }

}
