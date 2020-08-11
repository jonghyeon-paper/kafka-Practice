package com.example.demo.kafka.serializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.example.demo.model.DemoStructure;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoSerializer implements Serializer<DemoStructure> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // TODO Auto-generated method stub
    }

    @Override
    public byte[] serialize(String topic, DemoStructure data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            System.out.println("Unable to serialize object " + data);
            e.printStackTrace();
            //throw new RuntimeException(e);
            return null;
        }
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }
}
