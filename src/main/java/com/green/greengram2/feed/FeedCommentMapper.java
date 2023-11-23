package com.green.greengram2.feed;

import com.green.greengram2.feed.model.FeedCommentDelDto;
import com.green.greengram2.feed.model.FeedCommentInsDto;
import com.green.greengram2.feed.model.FeedCommentSelDto;
import com.green.greengram2.feed.model.FeedCommentSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedCommentMapper {

    int commentIns(FeedCommentInsDto dto);
    List<FeedCommentSelVo> selCommentAll(FeedCommentSelDto dto);
    int delComment(FeedCommentDelDto dto);
}
