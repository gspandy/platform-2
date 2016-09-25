package com.raycloud.module.request;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class TeacherAddRequest extends Request {


    //老师真实名字
    private String realName;
    //头像
    private MultipartFile headPic;
    //描述
    private String desc;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public MultipartFile getHeadPic() {
        return headPic;
    }

    public void setHeadPic(MultipartFile headPic) {
        this.headPic = headPic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
