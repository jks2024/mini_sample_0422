package com.kh.mini_sample_0422.dao;

import com.kh.mini_sample_0422.common.Common;
import com.kh.mini_sample_0422.vo.MovieVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MovieDAO {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement pStmt = null;
    // 영화 목록 생성
    public boolean insertMovie(MovieVO movieVO) {
        boolean isInsert = false;
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO MOVIES (MOVIE_ID, RANK, IMAGE, TITLE, SCORE, RATE, RESERVATION, OPEN_DATE) VALUES (movie_id_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, movieVO.getRank());
            pStmt.setString(2, movieVO.getImage());
            pStmt.setString(3, movieVO.getTitle());
            pStmt.setString(4, movieVO.getScore());
            pStmt.setString(5, movieVO.getRate());
            pStmt.setString(6, movieVO.getReservation());
            pStmt.setString(7, movieVO.getDate());
            int result = pStmt.executeUpdate();
            if(result == 1) isInsert = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(pStmt);
        Common.close(conn);
        return isInsert;
    }

}
