package com.sky.music.demo.services;

import com.sky.music.demo.domain.Music;
import com.sky.music.demo.repo.MusicRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class MusicServiceDBUnitTest {

    @Autowired
    private MusicService service;

    @MockBean
    private MusicRepo repo;

    @Test
    void testUpdate() {
        int id = 24;

        Optional<Music> found = Optional.of(new Music(id, "rap", "usa", "eminem", 1999));
        Music updated = new Music(id, "rap", "canada", "drake", 2008);

        Mockito.when(this.repo.findById(id)).thenReturn(found);
        Mockito.when(this.repo.save(updated)).thenReturn(updated);

        Assertions.assertEquals(updated, this.service.updateMusic(id, "rap","canada", "drake", 2008));

        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).save(updated);
    }
}
