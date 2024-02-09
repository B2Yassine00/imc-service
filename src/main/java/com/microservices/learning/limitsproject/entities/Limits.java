package com.microservices.learning.limitsproject.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Limits {

    private double first_born;
    private double second_born;
    private double third_born;
    private double fourth_born;
    private double fifth_born;
}
