package com.raycloud.module.response;

import com.raycloud.module.pojo.TeacherInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class ViewTeacherList extends ListResponse implements Serializable{


    private static final long serialVersionUID = 4808392506531110138L;
    /**
     * id : 1
     * realName :
     * desc :
     * headPicUrl :
     * teacherAwardUrl :
     * authenticate : 1
     */

    private List<TeacherListBean> teacherList;

    public void toResponse(List<TeacherInfo> teacherInfoList){
        teacherList = new ArrayList<TeacherListBean>();
        TeacherListBean tlb = null;
        for(TeacherInfo item : teacherInfoList){
            tlb = new TeacherListBean();
            tlb.setHeadPicUrl(item.getHeadPicUrl());
            tlb.setDesc(item.getDesc());
            tlb.setAuthenticate(item.getAuthenticate());
            tlb.setRealName(item.getRealName());
            tlb.setTeacherAwardUrl(item.getTeacherAwardUrl());
            tlb.setId(item.getId());
            teacherList.add(tlb);
        }

    }

    public List<TeacherListBean> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherListBean> teacherList) {
        this.teacherList = teacherList;
    }

    public static class TeacherListBean implements Serializable{
        private static final long serialVersionUID = -255130697776315767L;
        private Long id;
        private String realName;
        private String desc;
        private String headPicUrl;
        private String teacherAwardUrl;
        private int authenticate;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getHeadPicUrl() {
            return headPicUrl;
        }

        public void setHeadPicUrl(String headPicUrl) {
            this.headPicUrl = headPicUrl;
        }

        public String getTeacherAwardUrl() {
            return teacherAwardUrl;
        }

        public void setTeacherAwardUrl(String teacherAwardUrl) {
            this.teacherAwardUrl = teacherAwardUrl;
        }

        public int getAuthenticate() {
            return authenticate;
        }

        public void setAuthenticate(int authenticate) {
            this.authenticate = authenticate;
        }
    }
}
