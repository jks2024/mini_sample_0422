package com.kh.mini_sample_0422.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        for (Map<String, String> data : movieList) {
            String rank = data.get("rank");
            String image = data.get("image");
            String title = data.get("title");
            String score = data.get("score");
            // 기타 필드 처리...
            System.out.println("rank : " + rank);
            System.out.println("image : " + image);
            System.out.println("title : " + title);
            System.out.println("score : " + score);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
