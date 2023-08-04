package com.example.demo.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class GenericJsonDeserializer<T> implements Deserializer<T> {

    private final Class<T> type;

    public GenericJsonDeserializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No configuration needed
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        T myObj = null;
        try {
            myObj = mapper.readValue(data, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myObj;
    }

    @Override
    public void close() {
        // No resources to close
    }
}

