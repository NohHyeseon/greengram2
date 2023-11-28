package com.green.greengram2.user;

import com.green.greengram2.ResVo;
import com.green.greengram2.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;


        public UserSigninVo userSignin(UserSigninDto dto) {

            UserSigninProcVo savedVo = mapper.selUserForSignin(dto);
            String savedPw = savedVo.getUpw(); //DB에서 가져온 비밀번호
            boolean comparedPw = BCrypt.checkpw(dto.getUpw(), savedPw);
            UserSigninVo vo = new UserSigninVo();
            if(savedVo ==null) {
                vo.setResult(2);
                return vo;
            } else if(!BCrypt.checkpw(dto.getUpw(), savedVo.getUpw())) {
                vo.setResult(3);
                return vo;
            }
            vo.setResult(1);
            vo.setIuser(savedVo.getIuser());
            vo.setNm(savedVo.getNm());
            vo.setPic(savedVo.getPic());
            return vo;
        }


    public ResVo postIns(UserSignupDto dto) {
        String hashedPw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());
        log.info("hashedPw:{}", hashedPw);

        UserPkDto d1to = new UserPkDto(dto, hashedPw);
        mapper.userIns(d1to);
        int result = d1to.getIuser();
        ResVo rv = new ResVo();
        rv.setResult(result);
        return rv;
    }

    public UserinfoVo getIns(int targetIuser){
            UserinfoVo vo = mapper.userInfo(targetIuser);
            return vo;
    }

    public ResVo patchUserPic(UserPatchPicDto dto){
            int dto1= mapper.patchUserPic(dto);
            return new ResVo(dto1);
    }



}
