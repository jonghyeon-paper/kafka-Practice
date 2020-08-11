package com.example.demo.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.DemoStructure;

@SpringBootTest
public class ProducerTest {

    @Autowired
    private Producer producer;

    @Test
    public void call() {
        DemoStructure message = new DemoStructure();
        message.setId(123);
        message.setData("good!");
        message.setExtraData("bye~");
        producer.sendMessage(message);
    }
}
