package com.example.demo.Relationships;

import com.example.demo.Pojos.Release;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
public class AppearsOn {

    @Id @GeneratedValue
    private Long id;
    @Property("song_nr")
    private Integer songNr;

    @TargetNode
    private Release release;

    public Integer getSongNr() {
        return songNr;
    }

    public void setSongNr(Integer songNr) {
        this.songNr = songNr;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }
}
