package com.abc.demo.ott.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "genre_id")
    private int genreID;

    private String genreName;

    private String genreDescription;

    @ManyToMany(mappedBy = "videoGenreID")
    @JsonIgnore
    private Set<VideoEntity> videoEntitySet = new HashSet<>();

    public GenreEntity(String genreName, String genreDescription)  {
        this.genreName = genreName;
        this.genreDescription = genreDescription;
    }
}
