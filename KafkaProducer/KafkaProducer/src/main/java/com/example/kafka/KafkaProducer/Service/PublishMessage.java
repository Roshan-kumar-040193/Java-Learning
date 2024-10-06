package com.example.kafka.KafkaProducer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PublishMessage {

    @Autowired
    KafkaTemplate template;

    public void publishMessage(Object message){
        CompletableFuture<SendResult<String, Object>> send = template.send("spring-producer", message);
        send.whenComplete((result,ex)->{
           if(ex!=null){
               System.out.println("found an exception : "+ex);
           }
           else{
               System.out.println("producer response : "+result.toString());
           }
        });
    }

}
