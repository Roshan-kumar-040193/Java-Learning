package com.example.kafka.KafkaProducer.Service;

import com.example.kafka.KafkaProducer.Config.KafkaCustomConfig;
import com.example.kafka.KafkaProducer.POJO.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaCustomService {
    @Autowired
    KafkaTemplate kafkaTemplate;

    public String kafkaCustomMessage(Emp emp) {
        CompletableFuture<SendResult<String, Object>> send = kafkaTemplate.send("Spring-Topic-Custom",emp);

        // Initialize a variable to store the result
        final String[] resultMessage = {"Message Sent Successfully"};

        // Handling the CompletableFuture completion with result or exception
        send.whenComplete((result, ex) -> {
            if (ex != null) {
                // Update the result message in case of an error
                resultMessage[0] = "Exception occurred: " + ex.getMessage();
            } else {
                // Update with success result if successful
                resultMessage[0] = "Message Sent: " + result.getProducerRecord().value();
            }
        });

        // Return the result (note: this will likely execute before the async task completes)
        return resultMessage[0];
    }

}
