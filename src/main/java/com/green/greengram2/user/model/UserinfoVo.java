package com.green.greengram2.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserinfoVo {
    private int feedCnt;//등록한 피드수
    private int favCnt; //등록한 피드에 달린 좋아요 수
    private String nm;
    private String createdAt;//가입한날짜
    private String pic;
}
