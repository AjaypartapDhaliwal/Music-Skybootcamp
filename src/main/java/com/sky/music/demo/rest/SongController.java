package com.sky.music.demo.rest;

import com.sky.music.demo.domain.Song;
import com.sky.music.demo.dtos.SongDTO;
import com.sky.music.demo.services.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    private SongService service;

    public SongController(SongService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Song createSong(@RequestBody Song song) {
        return this.service.createSong(song);
    }

    @GetMapping("/get")
    public List<SongDTO> getSongs() {
        return this.service.getSongs();
    }
}
