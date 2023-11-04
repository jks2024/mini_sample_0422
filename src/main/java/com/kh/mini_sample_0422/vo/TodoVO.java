package com.kh.mini_sample_0422.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoVO {
    private Long todoId;
    private String userId;
    private String text;
    private boolean checked;
}
