package com.example.lab8_20210751.Dao;

import com.example.lab8_20210751.Entity.MovieWEB;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MovieDao {



    public List<MovieWEB> listarActiveMovies(){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization","Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlODhlMTQ2YzcwZDgyMWZjYzYzNzA5NzViNWZlMzRiYyIsInN1YiI6IjY2NjkwMjc4MTcwMGEwMGFhNTFkZGFkOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1UdT-TDzIUQD4E7n0ED8O9C4YDI68Flm1QNCmq5_-JM");

        HttpEntity<MovieWEB> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<MovieWEB> responseEntity = restTemplate.exchange("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1/", HttpMethod.GET,entity,MovieWEB.class);

        List<MovieWEB> listaMovies = new ArrayList<>();
        listaMovies  = Arrays.asList(responseEntity.getBody());
        return listaMovies;
    }

}
