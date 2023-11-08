package com.kh.mini_sample_0422.controller;
import com.kh.mini_sample_0422.dao.CommentDAO;
import com.kh.mini_sample_0422.vo.CommentVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.kh.mini_sample_0422.common.Common.CORS_ORIGIN;

@CrossOrigin(origins = CORS_ORIGIN)
@RestController
@RequestMapping("/api/comment")
public class CommentController {
    // GET : 댓글 목록 조회
    @GetMapping("/list/{boardId}")
    public ResponseEntity<List<CommentVO>> commentList(@PathVariable Long boardId) {
        CommentDAO dao = new CommentDAO();
        List<CommentVO> list = dao.getCommentList(boardId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    // GET : 댓글 상세 조회
    @GetMapping("/detail/{boardId}/{commentId}")
    public ResponseEntity<CommentVO> commentDetail(@PathVariable Long boardId, @PathVariable Long commentId) {
        CommentDAO dao = new CommentDAO();
        CommentVO commentVO = dao.getCommentDetail(boardId, commentId);
        return new ResponseEntity<>(commentVO, HttpStatus.OK);
    }
    // POST : 댓글 등록
    @PostMapping("/new")
    public ResponseEntity<Boolean> commentRegister(@RequestBody CommentVO commentVO) {
        System.out.println("boardId : " + commentVO.getBoardId());
        System.out.println("comment : " + commentVO.getContent());
        System.out.println("userId : " + commentVO.getUserId());
        CommentDAO dao = new CommentDAO();
        boolean isTrue = dao.insertComment(commentVO);
        System.out.println("댓글 등록 결과 : " + isTrue);
        return new ResponseEntity<>(isTrue, HttpStatus.OK);
    }
    // PUT : 댓글 수정
    @PutMapping("/{boardId}/{commentId}")
    public ResponseEntity<Boolean> commentModify(@PathVariable Long boardId, @PathVariable Long commentId, @RequestBody CommentVO commentVO) {
        return null;
    }
    // DELETE : 댓글 삭제
    @DeleteMapping("/{boardId}/{commentId}")
    public ResponseEntity<Boolean> commentDelete(@PathVariable Long boardId, @PathVariable Long commentId) {
        return null;
    }
}
