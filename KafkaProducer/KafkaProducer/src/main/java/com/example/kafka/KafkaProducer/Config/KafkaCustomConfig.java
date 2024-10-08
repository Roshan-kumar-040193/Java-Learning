package com.example.kafka.KafkaProducer.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaCustomConfig {
    @Bean
    public NewTopic createNewTopicForCustomData(){
        return new NewTopic("Spring-Topic-Custom",3, (short) 1);
    }
}
