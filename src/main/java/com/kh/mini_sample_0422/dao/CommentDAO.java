package com.kh.mini_sample_0422.dao;

import com.kh.mini_sample_0422.common.Common;
import com.kh.mini_sample_0422.vo.CommentVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement pStmt = null;
    // 댓글 목록
    public List<CommentVO> getCommentList(Long boardId) {
        List<CommentVO> commentList = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM COMMENTS WHERE BOARD_ID = " + boardId;
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                CommentVO commentVO = new CommentVO();
                commentVO.setCommentId(rs.getLong("COMMENT_ID"));
                commentVO.setBoardId(rs.getLong("BOARD_ID"));
                commentVO.setUserId(rs.getString("USER_ID"));
                commentVO.setContent(rs.getString("CONTENT"));
                commentVO.setRegDate(rs.getDate("REG_DATE"));
                commentList.add(commentVO);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);
        return commentList;
    }
    // 댓글 상세
    public CommentVO getCommentDetail(Long boardId, Long commentId) {
        CommentVO commentVO = new CommentVO();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM COMMENTS WHERE BOARD_ID = " + boardId + " AND COMMENT_ID = " + commentId;
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                commentVO.setCommentId(rs.getLong("COMMENT_ID"));
                commentVO.setBoardId(rs.getLong("BOARD_ID"));
                commentVO.setUserId(rs.getString("USER_ID"));
                commentVO.setContent(rs.getString("CONTENT"));
                commentVO.setRegDate(rs.getDate("REG_DATE"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);
        return commentVO;
    }
    // 댓글 등록
    public boolean insertComment(CommentVO commentVO) {
        boolean isInsert = false;
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO COMMENTS VALUES(COMMENT_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
            pStmt = conn.prepareStatement(sql);
            pStmt.setLong(1, commentVO.getBoardId());
            pStmt.setString(2, commentVO.getUserId());
            pStmt.setString(3, commentVO.getContent());
            int result = pStmt.executeUpdate();
            if(result == 1) isInsert = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
        return isInsert;
    }
    // 댓글 수정
    public boolean updateComment(CommentVO commentVO) {
        String sql = "UPDATE COMMENTS SET CONTENT = ? WHERE COMMENT_ID = ?";
        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, commentVO.getContent());
            pStmt.setLong(2, commentVO.getCommentId());
            int result = pStmt.executeUpdate();
            if(result == 1) return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
        return false;
    }
    // 댓글 삭제
    public boolean deleteComment(Long id) {
        String sql = "DELETE FROM COMMENTS WHERE COMMENT_ID = ?";
        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setLong(1, id);
            int result = pStmt.executeUpdate();
            if(result == 1) return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
        return false;
    }
}
