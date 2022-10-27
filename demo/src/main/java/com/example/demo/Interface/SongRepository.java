package com.example.demo.Interface;

import com.example.demo.Pojos.Release;
import com.example.demo.Pojos.Song;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

public interface SongRepository extends ReactiveNeo4jRepository<Song, Long> {
    Mono<Song> findOneByName(String name);

}
