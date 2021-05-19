package com.learncode24h.demokafka.controller;

import com.learncode24h.demokafka.consumer.KafkaConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class KafkaController {
    private KafkaTemplate<String, String> template;
    private KafkaConsumer kafkaConsumer;

    public KafkaController(KafkaTemplate<String, String> template, KafkaConsumer kafkaConsumer) {
        this.template = template;
        this.kafkaConsumer = kafkaConsumer;
    }

    @GetMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        template.send("test", message);
    }

    @GetMapping("/kafka/messages")
    public List<String> getMessages() {
        return kafkaConsumer.getMessages();
    }
}