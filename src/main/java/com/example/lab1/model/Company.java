package com.example.lab1.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Company {
    @Id
    String id;
    String name;
}
