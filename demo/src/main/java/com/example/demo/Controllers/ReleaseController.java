package com.example.demo.Controllers;

import com.example.demo.Interface.ReleaseRepository;
import com.example.demo.Pojos.Release;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/releases")
public class ReleaseController {

    private final ReleaseRepository releaseRepository;
    public ReleaseController(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @PutMapping
    Mono<Release> createOrUpdateRelease(@RequestBody Release newRelease) {
        return releaseRepository.save(newRelease);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Release> getReleases() {
        return (Flux<Release>) releaseRepository.findAll();
    }

    @GetMapping("/by-name")
    Mono<Release> byName(@RequestParam String name) {
        return releaseRepository.findOneByName(name);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        releaseRepository.deleteById(id);
    }
}
