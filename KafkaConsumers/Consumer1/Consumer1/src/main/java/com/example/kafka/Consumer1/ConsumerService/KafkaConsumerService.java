package com.example.kafka.Consumer1.ConsumerService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.kafka.KafkaProducer.POJO.Emp;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics="Spring-Topic-Auto")
    public void ConsumeMessage(String message){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(message);
    }

    @KafkaListener(topics="Spring-Topic-Custom")
    public void ConsumeMessage(Emp message){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(message);
    }
}
