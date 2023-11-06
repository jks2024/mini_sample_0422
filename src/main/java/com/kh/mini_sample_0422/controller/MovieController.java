package com.kh.mini_sample_0422.controller;
import com.kh.mini_sample_0422.dao.MovieDAO;
import com.kh.mini_sample_0422.vo.MovieVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static com.kh.mini_sample_0422.common.Common.CORS_ORIGIN;

@CrossOrigin(origins = CORS_ORIGIN)
@RestController
@RequestMapping("/api/movie")
public class MovieController {
    @GetMapping("/list")
    public ResponseEntity<List<MovieVO>> movieList() {
        MovieDAO dao = new MovieDAO();
        List<MovieVO> list = dao.selectMovieList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
