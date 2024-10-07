package com.example.kafka.KafkaProducer.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic createNewTopic(){
        return new NewTopic("Spring-Topic-Auto",3, (short) 1);
    }
}
