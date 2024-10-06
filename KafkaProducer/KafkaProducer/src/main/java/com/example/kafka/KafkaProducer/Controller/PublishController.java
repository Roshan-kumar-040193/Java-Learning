package com.example.kafka.KafkaProducer.Controller;

import com.example.kafka.KafkaProducer.Service.PublishMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    @Autowired
    PublishMessage publish;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publisheMessage(@PathVariable String message){
        publish.publishMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }

}
