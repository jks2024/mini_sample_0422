package com.kh.mini_sample_0422.vo;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
public class MemberVO {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private Date join;
}
