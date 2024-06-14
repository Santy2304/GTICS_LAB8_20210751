package com.example.lab8_20210751.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private String title;
    private String overview;
    private Float popularity;
    private String  release_date;

}
