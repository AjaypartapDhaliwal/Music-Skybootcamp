package com.sky.music.demo.services;

import com.sky.music.demo.domain.Song;
import com.sky.music.demo.dtos.SongDTO;
import com.sky.music.demo.repo.SongRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    private SongRepo repo;

    public SongService(SongRepo songRepo) {
        this.repo = songRepo;
    }

    public Song createSong(Song song) {
        return this.repo.save(song);
    }

    public List<SongDTO> getSongs() {

        List<SongDTO> dtos = new ArrayList<>();

        for (Song song : this.repo.findAll()) {
            dtos.add(new SongDTO(song));
        }

        return dtos;
    }
}
