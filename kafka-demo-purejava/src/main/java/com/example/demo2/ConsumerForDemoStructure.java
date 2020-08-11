package com.example.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerForDemoStructure {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "com.example.demo2.serializer.DemoDeserializer");
        properties.put("group.id", "test-group");

        KafkaConsumer<String, DemoStructure> kafkaConsumer = new KafkaConsumer<>(properties);
        List<String> topics = new ArrayList<>();
        topics.add("demo-topic-1");
        kafkaConsumer.subscribe(topics);
        try {
            while (true) {
                ConsumerRecords<String, DemoStructure> records = kafkaConsumer.poll(1);
                for (ConsumerRecord<String, DemoStructure> record : records) {
                    System.out.println(String.format("Topic - %s, Partition - %d, Value: %s", record.topic(),
                            record.partition(), record.value()));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            kafkaConsumer.close();
        }
    }
}
