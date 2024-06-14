package com.example.lab8_20210751.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmovie", nullable = false)
    private Integer idMovie;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User idUser;

    @Column(name = "original_title", nullable = false, length = 45)
    private String original_title;

    @Column(name = "overview", nullable = false, length = 45)
    private String overview;

    @Column(name = "release_date", nullable = false)
    private LocalDate release_date;

    @Column(name = "popularity", nullable = false)
    private Float popularity;

}
