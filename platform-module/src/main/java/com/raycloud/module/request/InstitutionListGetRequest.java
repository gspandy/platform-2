package com.raycloud.module.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/8/24.
 */
public class InstitutionListGetRequest extends RequestList {
    //机构名称
    private String institution;

    //用户名
    private String username;

    //账户状态
    private Integer status;

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
