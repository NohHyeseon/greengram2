package com.green.greengram2.feed.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FeedCommentDelDto {
    private int ifeedComment;
    private int loginedIuser;
}
