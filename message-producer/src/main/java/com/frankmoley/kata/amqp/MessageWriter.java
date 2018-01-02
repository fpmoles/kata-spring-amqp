package com.frankmoley.kata.amqp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class MessageWriter implements CommandLineRunner{
    @Value("${amqp.queue.name}")
    private String queueName;

    private final RabbitTemplate rabbitTemplate;
    private final ConfigurableApplicationContext context;
    private final ObjectMapper objectMapper;

    public MessageWriter(RabbitTemplate rabbitTemplate, ConfigurableApplicationContext context, ObjectMapper objectMapper){
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
        this.objectMapper = objectMapper;
    }


    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String dateTime = LocalTime.now().format(dtf);
        Sprocket sprocket = new Sprocket(UUID.randomUUID().toString(), "Sprocket: " + dateTime, "Sprocket created for  Rabbit on " + dateTime);
        System.out.println("Adding new Sprocket");
        String jsonString = objectMapper.writeValueAsString(sprocket);
        System.out.println(jsonString);
        rabbitTemplate.convertAndSend(queueName,jsonString);
        context.close();
    }
}
