package com.raycloud.request;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class TeacherListGetRequest extends Request {

    private static final long serialVersionUID = -3915190473682794349L;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
