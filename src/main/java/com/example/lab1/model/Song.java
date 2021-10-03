package com.example.lab1.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "songs")
public class Song {

    public Song(){
        this.id = UUID.randomUUID().toString();
    }

    @Id
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "dateOfCreation")
    private String dateOfCreation;
}