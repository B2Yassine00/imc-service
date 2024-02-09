package com.microservices.learning.limitsproject.controllers;

import com.microservices.learning.limitsproject.DTO.Indice;
import com.microservices.learning.limitsproject.entities.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class LimitsController {

    @Autowired
    private Environment env;


    @GetMapping("/limits")
    public Limits returnLimits(){
        Limits limit_s = new Limits(Double.parseDouble(Objects.requireNonNull(env.getProperty("limits-service.first_born"))),
                Double.parseDouble(Objects.requireNonNull(env.getProperty("limits-service.second_born"))),
                Double.parseDouble(Objects.requireNonNull(env.getProperty("limits-service.third_born"))),
                Double.parseDouble(Objects.requireNonNull(env.getProperty("limits-service.fourth_born"))),
                Double.parseDouble(Objects.requireNonNull(env.getProperty("limits-service.fifth_born"))));
        return limit_s;
    }

    @GetMapping("/calculate_indicator")
    public Indice returnTheObjects(@RequestParam double masse, @RequestParam double taille, @RequestParam int age){

        Limits limit_s = new Limits(Double.parseDouble(Objects.requireNonNull(env.getProperty("limits-service.first_born"))),
                Double.parseDouble(Objects.requireNonNull(env.getProperty("limits-service.second_born"))),
                Double.parseDouble(Objects.requireNonNull(env.getProperty("limits-service.third_born"))),
                Double.parseDouble(Objects.requireNonNull(env.getProperty("limits-service.fourth_born"))),
                Double.parseDouble(Objects.requireNonNull(env.getProperty("limits-service.fifth_born"))));

        String type;
        double imc = masse/((taille/100)*(taille/100));

        if(imc<limit_s.getFirst_born()){
            type = env.getProperty("rem_1");
        } else if (imc>limit_s.getFirst_born() && imc< limit_s.getSecond_born()) {
           type = env.getProperty("rem_2");
        } else if (imc>limit_s.getSecond_born() && imc< limit_s.getThird_born()) {
            type = env.getProperty("rem_3");
        }else if (imc>limit_s.getThird_born() && imc< limit_s.getFourth_born()) {
            type = env.getProperty("rem_4");
        }else if (imc>limit_s.getFourth_born() && imc< limit_s.getFifth_born()) {
            type = env.getProperty("rem_5");
        }else {
            type = env.getProperty("rem_6");
        }

        return new Indice(imc,type,age);
    }
}
