package com.sky.music.demo.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String genre;
    private String country;
    private String artist;
    @Column(name="releaseYear")
    private Integer year;

    @OneToMany(mappedBy = "music")
    private List<Song> songs;

    public Music(String genre, String country, String artist, int year) {
        super();
        this.genre = genre;
        this.country = country;
        this.artist = artist;
        this.year = year;
    }

    public Music(Integer id, String genre, String country, String artist, int year) {
        this.id = id;
        this.genre = genre;
        this.country = country;
        this.artist = artist;
        this.year = year;
    }

    public Music() {
        super();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
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

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return Objects.equals(id, music.id) && Objects.equals(genre, music.genre) && Objects.equals(country, music.country) && Objects.equals(artist, music.artist) && Objects.equals(year, music.year) && Objects.equals(songs, music.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genre, country, artist, year, songs);
    }
}
