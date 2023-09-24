package com.sky.music.demo.repo;

import com.sky.music.demo.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {
}
