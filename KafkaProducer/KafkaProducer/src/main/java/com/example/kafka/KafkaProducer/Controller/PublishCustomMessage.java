package com.example.kafka.KafkaProducer.Controller;

import com.example.kafka.KafkaProducer.POJO.Emp;
import com.example.kafka.KafkaProducer.Service.KafkaCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishCustomMessage {

    @Autowired
    KafkaCustomService service;

    @PutMapping("/custom-message")
    public ResponseEntity<String> sendCustomMessage(@RequestBody Emp emp){
        System.out.println(emp);
        service.kafkaCustomMessage(emp);
        return ResponseEntity.ok("the emp object is transfered");
    }

}
