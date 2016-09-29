/**
 * onway.com Inc.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.raycloud.module.pojo;

import com.raycloud.module.pojo.common.BasePojo;

import java.util.Date;

/**
 * @author junjie.lin
 * @version $Id: CrosseGoodTypePojo.java, v 0.1 2016/9/29 11:49 junjie.lin Exp $
 */
public class CrosseGoodattrAttrtempRelPojo extends BasePojo {

    private Integer id;
    private Integer attrtempId;
    private Integer goodaddrId;
    private Date gmtCreate;
    private Date gmtModified;
    private String gmtCreator;
    private String gmtModifier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttrtempId() {
        return attrtempId;
    }

    public void setAttrtempId(Integer attrtempId) {
        this.attrtempId = attrtempId;
    }

    public Integer getGoodaddrId() {
        return goodaddrId;
    }

    public void setGoodaddrId(Integer goodaddrId) {
        this.goodaddrId = goodaddrId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getGmtCreator() {
        return gmtCreator;
    }

    public void setGmtCreator(String gmtCreator) {
        this.gmtCreator = gmtCreator;
    }

    public String getGmtModifier() {
        return gmtModifier;
    }

    public void setGmtModifier(String gmtModifier) {
        this.gmtModifier = gmtModifier;
    }
}
