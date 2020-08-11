package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.kafka.Producer;
import com.example.demo.model.DemoStructure;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    private final Producer producer;

    @Autowired
    DemoController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(DemoStructure message) {
        this.producer.sendMessage(message);
    }
}
