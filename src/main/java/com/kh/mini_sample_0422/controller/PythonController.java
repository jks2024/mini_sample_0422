package com.kh.mini_sample_0422.controller;
import com.kh.mini_sample_0422.dao.MovieDAO;
import com.kh.mini_sample_0422.vo.MovieVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/python")
public class PythonController {
    @PostMapping("/books")
    public ResponseEntity<Boolean> getBooks(@RequestBody Map<String, String> data) {
        String title = data.get("title");
        String author = data.get("author");
        String content = data.get("content");
        System.out.println("title : " + title);
        System.out.println("author : " + author);
        System.out.println("content : " + content);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @PostMapping("/movies")
    public ResponseEntity<Boolean> getMovies(@RequestBody List<Map<String, String>> movieList) {
        MovieDAO dao = new MovieDAO();
        for (Map<String, String> data : movieList) {
            String rank = data.get("rank");
            String image = data.get("image");
            String title = data.get("title");
            String score = data.get("score");
            String rate = data.get("eval_num");
            String reservation = data.get("reservation");
            String date = data.get("open_date");
            MovieVO movieVO = new MovieVO(rank, image, title, score, rate, reservation, date);
            //System.out.println(movieVO);
            dao.insertMovie(movieVO);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @DeleteMapping("/movies")
    public ResponseEntity<Boolean> deleteMovies() {
        MovieDAO dao = new MovieDAO();
        dao.deleteMovie();
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
