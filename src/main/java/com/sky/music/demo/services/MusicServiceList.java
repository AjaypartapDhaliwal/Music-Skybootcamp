//package com.sky.music.demo.services;
//
//import com.sky.music.demo.domain.Music;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class MusicServiceList implements MusicService {
//
//    private List<Music> musicList = new ArrayList<>();
//    @Override
//    public Music createMusic(Music music) {
//        musicList.add(music);
//        return this.musicList.get(this.musicList.size() - 1);
//    }
//
//    @Override
//    public Music getMusic(int id) {
//        if (id < this.musicList.size()) {
//            return this.musicList.get(id);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public List<Music> getAll() {
//        return this.musicList;
//    }
//
//    @Override
//    public Music updateMusic(Integer id, String genre, String country, String artist, Integer year) {
//        if (id >= this.musicList.size()) return null;
//        Music toUpdate = this.musicList.get(id);
//
//        if (genre != null) {
//            toUpdate.setGenre(genre);
//        }
//
//        if (artist != null) {
//            toUpdate.setArtist(artist);
//        }
//
//        if (country != null) {
//            toUpdate.setCountry(country);
//        }
//
//        if (year != null) {
//            toUpdate.setYear(year);
//        }
//
//        return toUpdate;
//    }
//
//    @Override
//    public String removeMusic(int id) {
//        if (id >= this.musicList.size()) return "NOT FOUND";
//        else {
//            this.musicList.remove(id);
//            return "Person removed";
//        }
//    }
//
//    @Override
//    public Music findMusicByArtist(String artist) {
//        return null;
//    }
//}
