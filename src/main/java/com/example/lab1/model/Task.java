package com.example.lab1.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "task")
public class Task {

    public Task(){
        this.id = UUID.randomUUID().toString();
    }

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "dateOfCreation")
    private String dateOfCreation;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "song_id")
    private Song song;
}
