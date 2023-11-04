package com.kh.mini_sample_0422.dao;

import com.kh.mini_sample_0422.common.Common;
import com.kh.mini_sample_0422.vo.TodoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pStmt = null;

    // GET : 할 일 목록 조회
    public List<TodoVO> todoList(String userId) {
        List<TodoVO> list = new ArrayList<>();
        String sql = "SELECT * FROM T_TODO WHERE MEMBER_ID = ?";
        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, userId);
            rs = pStmt.executeQuery();
            while(rs.next()) {
                TodoVO todoVO = new TodoVO();
                todoVO.setTodoId(rs.getLong("ID"));
                todoVO.setUserId(rs.getString("MEMBER_ID"));
                todoVO.setText(rs.getString("TEXT"));
                todoVO.setChecked(rs.getBoolean("CHECKED"));
                list.add(todoVO);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(pStmt);
        Common.close(conn);
        return list;
    }
    // POST : 할 일 등록
    public boolean todoRegister(TodoVO todoVO) {
        String sql = "INSERT INTO T_TODO (ID, MEMBER_ID, TEXT, CHECKED) VALUES (todo_seq.NEXTVAL, ?, ?, ?)";
        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, todoVO.getUserId());
            pStmt.setString(2, todoVO.getText());
            pStmt.setBoolean(3, todoVO.isChecked());
            int result = pStmt.executeUpdate();
            if(result == 1) return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
        return false;
    }
    // PUT : 할 일 수정
    public boolean todoModify(Long id) {
        String sql = "UPDATE T_TODO SET CHECKED = CASE WHEN CHECKED = 'Y' THEN 'N' ELSE 'Y' END WHERE ID = ?";
        try {
            conn = Common.getConnection();
            pStmt = conn.prepareStatement(sql);
            pStmt.setLong(1, id);
            int result = pStmt.executeUpdate();
            System.out.println("RESULT : " + result);
            if(result == 1) return true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
        return false;
    }
    // DELETE : 할 일 삭제
    public boolean todoDelete(Long id) {
        String sql = "DELETE FROM T_TODO WHERE ID = ?";
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
