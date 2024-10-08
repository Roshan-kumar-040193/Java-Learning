package com.example.kafka.KafkaProducer.POJO;

import lombok.Data;

import java.io.Serializable;

@Data
public class Deptartment implements Serializable {
    String deptName;
    Emp manager;
}
