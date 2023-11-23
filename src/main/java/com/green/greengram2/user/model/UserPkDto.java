package com.green.greengram2.user.model;

import lombok.Builder;
import lombok.Data;


@Data
public class UserPkDto {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String pic;


    //생성자를 통한 박스갈이
    public UserPkDto(UserSignupDto dto, String hashedPw){
        this.uid=dto.getUid();
        //this.upw=dto.getUpw();
        this.upw=hashedPw;
        this.nm=dto.getNm();
        this.pic=dto.getPic();
    }

}


