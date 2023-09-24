package com.sky.music.demo.services;

import com.sky.music.demo.domain.Music;
import com.sky.music.demo.domain.Song;
import com.sky.music.demo.dtos.MusicDTO;
import com.sky.music.demo.dtos.SongDTO;
import com.sky.music.demo.repo.MusicRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class MusicServiceDB implements MusicService {

    private MusicRepo musicRepo;

    public MusicServiceDB(MusicRepo musicRepo) {
        this.musicRepo = musicRepo;
    }
    @Override
    public Music createMusic(Music music) {
        return this.musicRepo.save(music);
    }

    @Override
    public Music getMusic(int id) {
        Optional<Music> found = this.musicRepo.findById(id);
        return found.get();
    }

    @Override
    public List<MusicDTO> getAll() {

        List<MusicDTO> dtos = new ArrayList<>();

        for (Music music : this.musicRepo.findAll()) {
            dtos.add(new MusicDTO(music));
        }

        return dtos;
    }

    @Override
    public Music updateMusic(Integer id, String genre, String country, String artist, Integer year) {

        Music toUpdated = this.getMusic(id);

        if (genre != null) {
            toUpdated.setGenre(genre);
        }

        if (artist != null) {
            toUpdated.setArtist(artist);
        }

        if (country != null) {
            toUpdated.setCountry(country);
        }

        if (year != null) {
            toUpdated.setYear(year);
        }

        return this.musicRepo.save(toUpdated);
    }

    @Override
    public String removeMusic(int id) {
        if (this.musicRepo.existsById(id)) {
            this.musicRepo.deleteById(id);
            return "Person removed";
        } else {
            return "NOT FOUND";
        }
    }

    @Override
    public Music findMusicByArtist(String artist) {
        return this.musicRepo.findByArtistIgnoreCase(artist);
    }
}
