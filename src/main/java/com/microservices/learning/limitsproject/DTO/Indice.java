package com.microservices.learning.limitsproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Indice {

    private double imc;

    private String type;

    private int age;
}
