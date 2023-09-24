package com.sky.music.demo.dtos;

import com.sky.music.demo.domain.Music;
import com.sky.music.demo.domain.Song;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class MusicDTO {

    private Integer id;
    private String genre;
    private String country;
    private String artist;
    private Integer year;
    private List<SongDTO> songs;

    public MusicDTO(Music music) {
        this.id = music.getId();
        this.country = music.getCountry();;
        this.genre = music.getGenre();
        this.artist = music.getArtist();
        this.year = music.getYear();
        List<SongDTO> dtos = new ArrayList<>();
        for (Song song : music.getSongs()) {
            dtos.add(new SongDTO(song));
        }
        this.songs = dtos;
    }

    public MusicDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<SongDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDTO> songs) {
        this.songs = songs;
    }
}
