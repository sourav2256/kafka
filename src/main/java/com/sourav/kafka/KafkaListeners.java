package com.sourav.kafka;

import com.sourav.kafka.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "code",
            groupId = "groupID",
            containerFactory = "factory")
    void listener(Message data) {
        System.out.println("Listener received " + data + " ❤");
    }
}
