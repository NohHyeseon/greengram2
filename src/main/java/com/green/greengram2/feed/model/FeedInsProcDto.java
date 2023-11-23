package com.green.greengram2.feed.model;

import lombok.Data;

import java.util.List;

@Data
public class FeedInsProcDto {
    private int ifeed;
    private int iuser;
    private String contents;
    private String location;
    private List<String> pics;

    public FeedInsProcDto(FeedInsDto dto){
        this.iuser=dto.getIuser();
        this.contents=dto.getContents();
        this.location=dto.getLocation();
        this.pics = dto.getPics();
    }

}
