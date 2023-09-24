package com.sky.music.demo.repo;

import com.sky.music.demo.dtos.MusicDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sky.music.demo.domain.Music;

@Repository
public interface MusicRepo extends JpaRepository<Music, Integer> {

    Music findByArtistIgnoreCase(String artist);
}
