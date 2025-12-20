package com.example.trackingservice.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaShipmentTopicConfig {

    @Bean
    public NewTopic shipmentTopic(){
        return TopicBuilder
                .name("shipmet_created_topic")
                .build();
    }
}
