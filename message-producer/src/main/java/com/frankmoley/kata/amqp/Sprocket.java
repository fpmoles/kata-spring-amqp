package com.frankmoley.kata.amqp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sprocket {
    private String id;
    private String name;
    private String description;


}
