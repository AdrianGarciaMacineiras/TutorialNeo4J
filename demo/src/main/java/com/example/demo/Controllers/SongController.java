package com.example.demo.Controllers;

import com.example.demo.Interface.SongRepository;
import com.example.demo.Pojos.Release;
import com.example.demo.Pojos.Song;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongRepository songRepository;
    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @PutMapping
    Mono<Song> createOrUpdateSong(@RequestBody Song newSong) {
        return songRepository.save(newSong);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Song> getSongs() {
        return (Flux<Song>) songRepository.findAll();
    }

    @GetMapping("/by-name")
    Mono<Song> byName(@RequestParam String name) {
        return songRepository.findOneByName(name);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        songRepository.deleteById(id);
    }
}