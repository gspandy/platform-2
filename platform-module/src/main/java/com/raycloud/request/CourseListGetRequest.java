package com.raycloud.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class CourseListGetRequest extends RequestList {

    private static final long serialVersionUID = -4838956040412412823L;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
