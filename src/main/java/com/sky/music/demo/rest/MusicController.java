package com.sky.music.demo.rest;

import com.sky.music.demo.domain.Music;
import com.sky.music.demo.dtos.MusicDTO;
import com.sky.music.demo.services.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MusicController {

    private MusicService service;

    public MusicController(MusicService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String test() {
        return "Hello";
    }

    @PostMapping("/create")
    public ResponseEntity<Music> createMusic(@RequestBody Music music) {
        return new ResponseEntity<>(this.service.createMusic(music), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Music> getMusic(@PathVariable int id) {
        System.out.println("ID: " + id);

        Music found = this.service.getMusic(id);

        if (found == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(found);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MusicDTO>> getMusicList() {

        if (this.service.getAll().isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(this.service.getAll());
    }

    @PatchMapping("/update")
    public ResponseEntity<Music> updateMusic(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "genre", required = false) String genre,
            @RequestParam(name = "country", required = false) String country,
            @RequestParam(name = "artist", required = false) String artist,
            @RequestParam(name = "year", required = false) Integer year
    ) {

        Music updated = this.service.updateMusic(id, genre, country, artist, year);

        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok((updated));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removePerson(@PathVariable int id) {

        if (id >= this.service.getAll().size()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        this.service.removeMusic(id);
        return ResponseEntity.ok("ID: " + id + " removed");
    }
}
