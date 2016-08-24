package com.raycloud.response;

import com.raycloud.pojo.StudentInfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/8/23.
 */
public class ViewStudentList extends ListResponse {



    public void toResponse(List<StudentInfo> studentInfoList){
        if(studentInfoList == null || studentInfoList.size() == 0){
            return;
        }
        studentList = new ArrayList<StudentListBean>();
        StudentListBean studentListBean = null;
        Calendar c1 = Calendar.getInstance();
        for(StudentInfo s : studentInfoList){
            studentListBean = new StudentListBean();
            studentListBean.setId(s.getId());
            studentListBean.setUserId(s.getUserId());
            studentListBean.setStudyNo(s.getStudyNo());
            studentListBean.setAddress(s.getAddress());
            studentListBean.setPhone(s.getPhone());
            studentListBean.setRealName(s.getRealName());
            studentListBean.setSex(s.getSex());
            studentListBean.setTrain(s.getTrain() == 1 ? "是" : "否");

            c1.setTimeInMillis(System.currentTimeMillis()
                    - s.getBirthday().getTime());
            studentListBean.setAge((int)(Math.floor((System.currentTimeMillis()
                    - s.getBirthday().getTime())/1000)/3600/24/365));
            studentList.add(studentListBean);
        }
    }

    /**
     * id : 1
     * userId : 1
     * studyNo : 19210001
     * realName : 林全
     * sex : 男
     * age :
     * phone :
     * address :
     * train : 是
     */

    private List<StudentListBean> studentList;

    public List<StudentListBean> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentListBean> studentList) {
        this.studentList = studentList;
    }


    public static class StudentListBean {
        private Long id;
        private Long userId;
        private String studyNo;
        private String realName;
        private String sex;
        private int age;
        private String phone;
        private String address;
        private String train;

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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
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

        public String getTrain() {
            return train;
        }

        public void setTrain(String train) {
            this.train = train;
        }
    }
}
