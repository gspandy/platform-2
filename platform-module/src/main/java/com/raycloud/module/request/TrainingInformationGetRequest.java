package com.raycloud.module.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class TrainingInformationGetRequest extends Request {
    private static final long serialVersionUID = 4483054758414355906L;

    //商家id(可选)
    private Long id;
    //商家名字(可选)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
