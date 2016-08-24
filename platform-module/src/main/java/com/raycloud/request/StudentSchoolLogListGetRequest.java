package com.raycloud.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/8/23.
 */
public class StudentSchoolLogListGetRequest extends RequestList{

    private Long userId;

    private String studyNo;

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
}
