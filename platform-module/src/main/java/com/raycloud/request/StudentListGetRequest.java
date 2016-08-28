package com.raycloud.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/8/23.
 */
public class StudentListGetRequest extends RequestList{

    private Long userId;

    private String studyNo;

    private String realName;

    //训练提高标识1需要,0不需要
    private Integer train;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getTrain() {
        return train;
    }

    public void setTrain(Integer train) {
        this.train = train;
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
}
