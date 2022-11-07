package com.cassandra.kafka.producer.kafkaProducer.configuration;


import com.cassandra.kafka.producer.kafkaProducer.model.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {
    @Bean
    public ProducerFactory<String, User> jsonProducerFactory(){
        Map<String,Object> config = new HashMap<String,Object>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<String,User>(config);
    }

    @Bean
    public KafkaTemplate<String,User> kafkaJsonTemplate(){
        return new KafkaTemplate<String,User>(jsonProducerFactory());
    }

    @Bean
    public ProducerFactory<String, String> stringProducerFactory(){
        Map<String,Object> config = new HashMap<String,Object>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<String,String>(config);
    }

    @Bean
    public KafkaTemplate<String,String> kafkaStringTemplate(){
        return new KafkaTemplate<String,String>(stringProducerFactory());
    }


}