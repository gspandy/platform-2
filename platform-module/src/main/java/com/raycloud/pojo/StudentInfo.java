package com.raycloud.pojo;

import com.raycloud.pojo.common.BasePojo;

import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/8/22.
 */
public class StudentInfo extends BasePojo {

    private Long id;
    private Long userId;
    private String studyNo;
    private String realName;
    private String sex;
    private Date birthday;
    private String phone;
    private String address;
    private Integer train;
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

    public String getStudyNo() {
        return studyNo;
    }

    public void setStudyNo(String studyNo) {
        this.studyNo = studyNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTrain() {
        return train;
    }

    public void setTrain(Integer train) {
        this.train = train;
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
