package com.frankmoley.kata.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SprocketProcessor {

    private final ObjectMapper objectMapper;

    public SprocketProcessor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void receiveMessage(String sprocketJson){
        System.out.println("Received Sprocket");
        Sprocket sprocket = null;
        try {
            sprocket = objectMapper.readValue(sprocketJson, Sprocket.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sprocket);

    }
}
