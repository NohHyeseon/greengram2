package com.green.greengram2.feed.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedSelVo {
    private int ifeed;
    private String contents;
    private String location;
    private int writerIuser;
    private String writerNm;
    private String createdAt;
    private String writerPic;
    private int isFav;
    private List<String> pics;
    private List<FeedCommentSelVo> comments;
    private int isMoreComment;//0:없음 1:더있음

}
