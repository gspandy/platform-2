package com.raycloud.request;

import com.sun.istack.internal.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class CourseAddRequest extends Request {

    @NotNull
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
