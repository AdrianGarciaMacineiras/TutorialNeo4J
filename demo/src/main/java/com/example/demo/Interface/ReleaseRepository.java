package com.example.demo.Interface;

import com.example.demo.Pojos.Release;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

public interface ReleaseRepository extends ReactiveNeo4jRepository<Release, Long> {
    Mono<Release> findOneByName(String name);

}
