package com.green.greengram2.feed;

import com.green.greengram2.ResVo;
import com.green.greengram2.feed.model.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
@Tag(name = "피드API", description = "피드 관련 처리")
public class FeedController {
    private final FeedService service;


    @Parameters(value = {
            @Parameter(name = "iuser", description = "유저"),
            @Parameter(name = "contents", description = "내용"),
            @Parameter(name = "location", description = "위치"),
            @Parameter(name = "pics", description = "사진")

    })
    @PostMapping
    public ResVo postFeed(@RequestBody FeedInsDto dto) {
        return service.insFeed(dto);
    }

    @GetMapping
    public List<FeedSelVo> getFeedAll(int page, int loginedIuser
            , @RequestParam(defaultValue = "0") int targetIuser) {
        log.info("{}", targetIuser);
        final int ROW_COUNT = 30;
        FeedSelDto dto = FeedSelDto.builder().startIdx((page - 1) * ROW_COUNT)
                .rowCount(ROW_COUNT)
                .loginedIuser(loginedIuser)
                .targetIuser(targetIuser)
                .build();


        return service.getFeedAll(dto);
    }

    //insert:1 delete:2
    @GetMapping("/fav")
    public ResVo toogllefeedFav(FeedFavDto dto) {
        log.info("dto:{}", dto);

        return service.delFav(dto);
    }

    @PostMapping("comment")
    public ResVo insComment(@RequestBody FeedCommentInsDto dto) {
        return service.insComment(dto);
    }

    @GetMapping("/comment")
    public List<FeedCommentSelVo> getComment(int ifeed) {
        return service.getContentAll(ifeed);
    }

    @DeleteMapping
    public ResVo delFeed(FeedDelDto dto){
        return service.delFeed(dto);

    }

    @DeleteMapping("/comment")
    public ResVo delComment(@RequestParam("ifeed_comment") int ifeedcomment,
                            @RequestParam("logined_iuser")int loginedIuser){
        log.info("ifeedComment:{}, loginedIuser: {}", ifeedcomment, loginedIuser);
        FeedCommentDelDto dto=new FeedCommentDelDto(ifeedcomment,loginedIuser);
        return service.delComment(dto);
    }
}

