package com.example.demo.kafka;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.demo.model.DemoStructure;

@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "demo-topic-1", groupId = "group-id", containerFactory = "demoKafkaListenerContainerFactory")
    public void consume(DemoStructure message) throws IOException {
        logger.info("Current thread: {}", Thread.currentThread().getName());
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }

//    @KafkaListener(topics = "demo-topic-1", containerFactory = "demoKafkaListenerContainerFactory")
    public void listenWithHeaders(@Payload DemoStructure message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: " + message + " from partition: " + partition);
    }
}
