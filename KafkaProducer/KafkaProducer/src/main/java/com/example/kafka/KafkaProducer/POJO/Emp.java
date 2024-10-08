package com.example.kafka.KafkaProducer.POJO;

import lombok.Data;

import java.io.Serializable;

@Data
public class Emp implements Serializable {

    String name;
    int age;
    Deptartment dept;

}
