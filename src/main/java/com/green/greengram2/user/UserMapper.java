package com.green.greengram2.user;

import com.green.greengram2.feed.model.FeedSelDto;
import com.green.greengram2.feed.model.FeedSelVo;
import com.green.greengram2.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int userIns(UserPkDto dto);
    UserSigninProcVo selUserForSignin(UserSigninDto dto);
    FeedSelVo selFeedAll(FeedSelDto dto);
    UserinfoVo userInfo(int targetIuser);
    int patchUserPic(UserPatchPicDto dto);

}
