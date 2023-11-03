package com.kh.mini_sample_0422.vo;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
public class BoardVO {
    private Long boardId;
    private String userId;
    private String title;
    private String content;
    private Date regDate;
}
