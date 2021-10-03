package com.example.lab1.services.impl;

import com.example.lab1.model.Song;
import com.example.lab1.repository.SongRepository;
import com.example.lab1.services.SongService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public void add(Song song) {
        songRepository.saveAndFlush(song);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song findByName(String name) {
        return null;
    }

    @Override
    public Song findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
