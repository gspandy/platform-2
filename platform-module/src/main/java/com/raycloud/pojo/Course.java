package com.raycloud.pojo;

import com.raycloud.pojo.common.BasePojo;

import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/23.
 */
public class Course extends BasePojo {

    private static final long serialVersionUID = 2379853842673679525L;
    private Long id;
    private Long userId;
    private String name;
    private String picUrl;
    private Date created;
    private Date modified;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
