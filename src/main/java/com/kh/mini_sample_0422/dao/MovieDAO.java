package com.kh.mini_sample_0422.dao;

import com.kh.mini_sample_0422.common.Common;
import com.kh.mini_sample_0422.vo.MovieVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    // 영화 목록 조회
    public List<MovieVO> selectMovieList() {
        String sql = "SELECT * FROM MOVIES";
        List<MovieVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                MovieVO movieVO = new MovieVO();
                movieVO.setRank(rs.getString("RANK"));
                movieVO.setImage(rs.getString("IMAGE"));
                movieVO.setTitle(rs.getString("TITLE"));
                movieVO.setScore(rs.getString("SCORE"));
                movieVO.setRate(rs.getString("RATE"));
                movieVO.setReservation(rs.getString("RESERVATION"));
                movieVO.setDate(rs.getString("OPEN_DATE"));
                list.add(movieVO);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);
        return list;
    }
}
