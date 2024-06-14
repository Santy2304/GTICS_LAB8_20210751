package com.example.lab8_20210751.Controller;

import com.example.lab8_20210751.Dao.MovieDao;
import com.example.lab8_20210751.Entity.MovieWEB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    MovieDao movieDao;

    @GetMapping({"/Movies"})
    public Object listarMovies(Model model) {
        HashMap<String, Object> responseJson = new HashMap<>();

        try{
            List<MovieWEB> listasMovies = movieDao.listarActiveMovies();
            responseJson.put("result","success");
            responseJson.put("Movies", listasMovies);
            return ResponseEntity.ok().body(responseJson);
        }catch (Exception e){
            System.out.println(e);
            responseJson.put("result","failure");
            return ResponseEntity.badRequest().body(responseJson);
        }

    }

}
