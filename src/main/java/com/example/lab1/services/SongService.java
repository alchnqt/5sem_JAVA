package com.example.lab1.services;

import com.example.lab1.model.Song;

import java.util.List;

public interface SongService {
    void add(Song song);

    List<Song> getAllSongs();

    Song findByName(String name);

    Song findById(Long id);

    void deleteById(Long id);
}
