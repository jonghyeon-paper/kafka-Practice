package com.example.demo.kafka.serializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.example.demo.model.DemoStructure;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoDeserializer implements Deserializer<DemoStructure> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // TODO Auto-generated method stub
    }

    @Override
    public DemoStructure deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(new String(data, "UTF-8"), DemoStructure.class);
        } catch (Exception e) {
            System.out.println("Unable to deserialize message {}" + data);
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
