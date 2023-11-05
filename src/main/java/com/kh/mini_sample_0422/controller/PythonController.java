package com.kh.mini_sample_0422.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/python")
public class PythonController {
    @RequestMapping("/books")
    public ResponseEntity<Boolean> hello(@RequestBody Map<String, String> data) {
        String title = data.get("title");
        String author = data.get("author");
        String content = data.get("content");
        System.out.println("title : " + title);
        System.out.println("author : " + author);
        System.out.println("content : " + content);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
