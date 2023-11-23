package com.green.greengram2;

import lombok.Data;

@Data
public class ResVo {
    private int result;

    public ResVo(){

    }

    public ResVo(int result){
        this.result=result;
    }

}
