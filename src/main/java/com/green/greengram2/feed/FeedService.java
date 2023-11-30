package com.green.greengram2.feed;

import com.green.greengram2.ResVo;
import com.green.greengram2.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final FeedPicsMapper picsMapper;
    private final FeedFavMapper favMapper;
    private final FeedCommentMapper cMapper;



    public ResVo insFeed(FeedInsDto dto) {
        if (dto.getPics() == null || dto.getPics().isEmpty()) {
            return new ResVo(2);
        }
        FeedInsProcDto dto1 = new FeedInsProcDto(dto);
        mapper.insFeed(dto1);
        FeedPicsProcDto dto2 = new FeedPicsProcDto(dto1);
        mapper.insFeedPic(dto2);
        int result = dto1.getIfeed();
        ResVo vo = new ResVo();
        vo.setResult(result);
        return vo;

    }

    public List<FeedSelVo> getFeedAll(FeedSelDto dto) {
        List<FeedSelVo> list = mapper.selFeedAll(dto);
        for (FeedSelVo vo : list) {
            List<String> pics = picsMapper.selFeedPicsAll(vo.getIfeed());
            vo.setPics(pics);
            //


            List<FeedCommentSelVo> comments = cMapper.selCommentAll(FeedCommentSelDto.builder()
                    .ifeed(vo.getIfeed())
                    .startIdx(0)
                    .rowCount(4)
                    .build());

            if (comments.size() == 4) {
                vo.setIsMoreComment(1);
                comments.remove(comments.size() - 1);
            }
            vo.setComments(comments);

        }
        return list;
    }

    public ResVo delFav(FeedFavDto dto) {
        int del = favMapper.delFav(dto);
        if (del == 1) {
            return new ResVo(0);
        } else {
            return new ResVo(favMapper.insFav(dto));
        }
    }

    public ResVo insComment(FeedCommentInsDto dto) {
        try {
            int ifeedComment = cMapper.commentIns(dto);
            ResVo vo = new ResVo(dto.getIfeedComment());
            return vo;
        } catch (Exception e) {
            return new ResVo();
        }
    }
    public List<FeedCommentSelVo> getContentAll(int ifeed){
        return  cMapper.selCommentAll(FeedCommentSelDto.builder()
                .ifeed(ifeed)
                .startIdx(4)
                .rowCount(9999)
                .build());
    }
    public ResVo delComment(FeedCommentDelDto dto){
        ResVo vo = new ResVo(cMapper.delComment(dto));
        return vo;
    }
    public ResVo delFeed(FeedDelDto dto) {
        FeedDelDto iuser = mapper.selFeed(dto.getIfeed());
        if (dto.getIuser() != iuser.getIuser()) {
            return new ResVo(0);
        } else if (iuser == null) {
            return new ResVo(0);
        }if (dto.getIuser() == iuser.getIuser()) {
            mapper.delPic(dto.getIfeed());
            mapper.delComment(dto.getIfeed());
            mapper.delFav(dto.getIfeed());
            mapper.delFeed(dto.getIfeed());
            return new ResVo(1);
        }
        return new ResVo(1);
    }
}
// controll에서 받은 정보를 서비스에 넘겨주고 서비스에서 박스갈이 한걸 불러와서 dto의값을 dto1에 집어넣는다