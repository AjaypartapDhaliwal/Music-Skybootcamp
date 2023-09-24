package com.sky.music.demo.dtos;

import com.sky.music.demo.domain.Song;

public class SongDTO {

    private Integer id;
    private String name;
    private Integer duration;
    private Integer artistId;

    public SongDTO(Song song) {
        this.id = song.getId();
        this.duration = song.getDuration();
        this.name = song.getName();
        if (song.getMusic() != null) {
            this.artistId = song.getMusic().getId();
        }
    }

    public SongDTO() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }
}
