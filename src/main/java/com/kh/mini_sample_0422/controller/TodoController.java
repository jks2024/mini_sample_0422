package com.kh.mini_sample_0422.controller;

import com.kh.mini_sample_0422.dao.TodoDAO;
import com.kh.mini_sample_0422.vo.TodoVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.kh.mini_sample_0422.common.Common.CORS_ORIGIN;

@CrossOrigin(origins = CORS_ORIGIN)
@RestController
@RequestMapping("/api/todo")
public class TodoController {
    // GET : 할 일 목록 조회
    @GetMapping("/list")
    public ResponseEntity<List<TodoVO>> getTodoList(@RequestParam String userId) {
        System.out.println("USER ID : " + userId);
        TodoDAO dao = new TodoDAO();
        List<TodoVO> list = dao.todoList(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // POST : 할 일 등록
    @PostMapping("/new")
    public ResponseEntity<Boolean> registerTodo(@RequestBody TodoVO todoVO) {
        TodoDAO dao = new TodoDAO();
        boolean isTrue = dao.todoRegister(todoVO);
        return new ResponseEntity<>(isTrue, HttpStatus.OK);
    }

    // PUT : 할 일 수정
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> modifyTodo(@PathVariable Long id) {
        System.out.println("ID : " + id);
        TodoDAO dao = new TodoDAO();
        boolean isTrue = dao.todoModify(id);
        System.out.println("수정 결과 : " + isTrue);
        return new ResponseEntity<>(isTrue, HttpStatus.OK);
    }
    // DELETE : 할 일 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTodo(@PathVariable Long id) {
        TodoDAO dao = new TodoDAO();
        boolean isTrue = dao.todoDelete(id);
        return new ResponseEntity<>(isTrue, HttpStatus.OK);
    }
}
