package com.example.meat;

import android.app.Application;

/**
 * Created by 王刚 on 2017/12/29.
 */

public class KeyModel extends Application {
    private Integer code;
    private String label;
    public KeyModel(Integer code,String lable){
        this.code = code;
        this.label = lable;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLable() {
        return label;
    }

    public void setLable(String lable) {
        this.label = lable;
    }
}
