package com.example.demo.kafka;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.DemoStructure;

@Component
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "demo-topic-1", groupId = "group-id")
    public void consume(DemoStructure message) throws IOException {
        logger.info("Current thread: {}", Thread.currentThread().getName());
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
