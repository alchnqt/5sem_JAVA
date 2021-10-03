package com.example.lab1.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Item {
    @Id
    private UUID id;
    private String parsedInfo;
    private Date createdTime;
    private String company;
    private String name;
    private BigDecimal price;
    private String description;
    private String category;
}
