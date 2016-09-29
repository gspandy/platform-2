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
public class CrosseGoodAttroptionsRelPojo extends BasePojo {

    private Integer id;
    private Integer goodNo;
    private Integer goodAttrId;
    private Integer goodAttroptionsId;
    private String goodAttrValue;
    private String stockNum;
    private double priceAmount;
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

    public Integer getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(Integer goodNo) {
        this.goodNo = goodNo;
    }

    public Integer getGoodAttrId() {
        return goodAttrId;
    }

    public void setGoodAttrId(Integer goodAttrId) {
        this.goodAttrId = goodAttrId;
    }

    public Integer getGoodAttroptionsId() {
        return goodAttroptionsId;
    }

    public void setGoodAttroptionsId(Integer goodAttroptionsId) {
        this.goodAttroptionsId = goodAttroptionsId;
    }

    public String getGoodAttrValue() {
        return goodAttrValue;
    }

    public void setGoodAttrValue(String goodAttrValue) {
        this.goodAttrValue = goodAttrValue;
    }

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    public double getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(double priceAmount) {
        this.priceAmount = priceAmount;
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
