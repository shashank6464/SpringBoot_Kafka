package com.cassandra.kafka.producer.kafkaProducer.service;

import com.cassandra.kafka.producer.kafkaProducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final String generalTopic = "generalPOC";
    @Autowired
    KafkaTemplate<String,String> generalTemplate;
    public void sendStringMessage(String name){
        generalTemplate.send(generalTopic,name);
    }



    private static final String JSONTopic = "jsonPOC";
    @Autowired
    KafkaTemplate<String, User> jsonTemplate;
    public void sendJsonMessage(User user){
        jsonTemplate.send(JSONTopic,user);
    }

}