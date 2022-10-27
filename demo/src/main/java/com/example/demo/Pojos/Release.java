package com.example.demo.Pojos;

import com.example.demo.Relationships.AppearsOn;
import com.example.demo.Relationships.AppearsOnReverse;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node
public class Release {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private Integer year;

    @Relationship(type="APPEARS_ON", direction = Relationship.Direction.INCOMING)
    private List<AppearsOnReverse> appearsOnReverses;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<AppearsOnReverse> getAppearsOnReverses() {
        return appearsOnReverses;
    }

    public void setAppearsOnReverses(List<AppearsOnReverse> appearsOnReverses) {
        this.appearsOnReverses = appearsOnReverses;
    }
}
