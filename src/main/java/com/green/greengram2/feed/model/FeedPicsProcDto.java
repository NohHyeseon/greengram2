package com.green.greengram2.feed.model;

import lombok.Data;

import java.util.List;

@Data
public class FeedPicsProcDto {
    private int ifeed;
    private List<String> pics;


    public FeedPicsProcDto(FeedInsProcDto dto){
        this.ifeed= dto.getIfeed();
        this.pics=dto.getPics();
    }

}
