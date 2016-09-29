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
public class CrosseAttrtempPojo extends BasePojo {

    private Integer id;
    private String attrtempName;
    private Integer goodTypeId;
    private String status;
    private Date gmtCreate;
    private Date gmtModified;
    private String gmtCreator;
    private String gmtModifier;
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttrtempName() {
        return attrtempName;
    }

    public void setAttrtempName(String attrtempName) {
        this.attrtempName = attrtempName;
    }

    public Integer getGoodTypeId() {
        return goodTypeId;
    }

    public void setGoodTypeId(Integer goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
