package com.raycloud.request;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class CourseAddRequest extends Request {

    private String name;
    private MultipartFile picUrl;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(MultipartFile picUrl) {
        this.picUrl = picUrl;
    }
}
