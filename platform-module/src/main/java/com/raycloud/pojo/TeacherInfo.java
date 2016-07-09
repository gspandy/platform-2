package com.raycloud.pojo;

import com.raycloud.pojo.common.BasePojo;

import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class TeacherInfo extends BasePojo{


    private static final long serialVersionUID = -3281622356828028627L;

    private Long id;
    private Long userId;
    private String realName;
    private String headPicUrl;
    private String desc;
    private String cardFrontUrl;
    private String cardBackUrl;
    private String cardNo;
    private String teacherAwardUrl;
    private Integer authenticate;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCardFrontUrl() {
        return cardFrontUrl;
    }

    public void setCardFrontUrl(String cardFrontUrl) {
        this.cardFrontUrl = cardFrontUrl;
    }

    public String getCardBackUrl() {
        return cardBackUrl;
    }

    public void setCardBackUrl(String cardBackUrl) {
        this.cardBackUrl = cardBackUrl;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getTeacherAwardUrl() {
        return teacherAwardUrl;
    }

    public void setTeacherAwardUrl(String teacherAwardUrl) {
        this.teacherAwardUrl = teacherAwardUrl;
    }

    public Integer getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Integer authenticate) {
        this.authenticate = authenticate;
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
