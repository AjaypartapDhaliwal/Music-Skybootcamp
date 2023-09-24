package com.sky.music.demo.services;

import com.sky.music.demo.domain.Music;
import com.sky.music.demo.dtos.MusicDTO;

import java.util.List;

public interface MusicService {

    Music createMusic(Music music);

    Music getMusic(int id);

    List<MusicDTO> getAll();

    Music updateMusic(
            Integer id,
            String genre,
            String country,
            String artist,
            Integer year
    );

    String removeMusic(int id);

    Music findMusicByArtist(String artist);
}
