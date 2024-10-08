package com.example.kafka.Consumer2.ConsumerService;

import com.example.kafka.KafkaProducer.POJO.Emp;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

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
