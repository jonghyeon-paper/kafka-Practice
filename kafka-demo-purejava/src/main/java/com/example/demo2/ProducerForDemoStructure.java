package com.example.demo2;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerForDemoStructure {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "com.example.demo2.serializer.DemoSerializer");

        KafkaProducer<String, DemoStructure> kafkaProducer = new KafkaProducer<>(properties);
        try {
            for (int i = 10; i < 15; i++) {
                System.out.println(i);
                DemoStructure newData = new DemoStructure(i, " DATA" + i, "ED" + i);
                kafkaProducer.send(new ProducerRecord<>("demo-topic-1", Integer.toString(i), newData));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            kafkaProducer.close();
        }
    }
}