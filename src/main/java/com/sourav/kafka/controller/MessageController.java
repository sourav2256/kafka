package com.sourav.kafka.controller;

import com.sourav.kafka.model.Message;
import com.sourav.kafka.model.MessageRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
    @PostMapping
    public void publish(@RequestBody MessageRecord messageRecord) {
        Message message = new Message(messageRecord.record(), LocalDateTime.now());
        //kafkaTemplate.send("code", messageRecord.toString());
        kafkaTemplate.send("code", message);

    }
}
