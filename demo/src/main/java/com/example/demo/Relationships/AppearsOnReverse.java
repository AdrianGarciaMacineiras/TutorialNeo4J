package com.example.demo.Relationships;

import com.example.demo.Pojos.Release;
import com.example.demo.Pojos.Song;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
public class AppearsOnReverse {

    @Id @GeneratedValue
    private Long id;
    @Property("song_nr")
    private Integer songNr;

    @TargetNode
    private Song song;

    public Integer getSongNr() {
        return songNr;
    }

    public void setSongNr(Integer songNr) {
        this.songNr = songNr;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
