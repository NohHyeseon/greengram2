package com.green.greengram2.feed;

import com.green.greengram2.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int insFeed(FeedInsProcDto dto);
    int insFeedPic(FeedPicsProcDto dto);

    List<FeedSelVo> selFeedAll(FeedSelDto dto);
    FeedDelDto selFeed(int ifeed);
    int delFeed(int ifeed);
    int delFav(int ifeed);
    int delPic(int ifeed);
    int delComment(int ifeed);
    // dfjksdfjjl

}
