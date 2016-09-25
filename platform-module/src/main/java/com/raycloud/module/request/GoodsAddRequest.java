package com.raycloud.module.request;

import java.math.BigDecimal;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/9/22.
 */
public class GoodsAddRequest extends Request {

    private Long id;

    private String name;

    private BigDecimal oriPrice;

    private BigDecimal currentPrice;

    private Long categoryId;//普通分类id

    private Integer rectNum; //推荐级别

    private Long seasonId;//季节分类id

    private Long leftId;//左侧导航栏分类id

    private Long programId;//栏目id

    private Integer sales;//销量

    private String picUrl;//封面图链接

    private String bonusUrl;//优惠券链接

    private String goodsUrl;//商品购买链接

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public BigDecimal getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(BigDecimal oriPrice) {
        this.oriPrice = oriPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getBonusUrl() {
        return bonusUrl;
    }

    public void setBonusUrl(String bonusUrl) {
        this.bonusUrl = bonusUrl;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getRectNum() {
        return rectNum;
    }

    public void setRectNum(Integer rectNum) {
        this.rectNum = rectNum;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Long getLeftId() {
        return leftId;
    }

    public void setLeftId(Long leftId) {
        this.leftId = leftId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }
}
