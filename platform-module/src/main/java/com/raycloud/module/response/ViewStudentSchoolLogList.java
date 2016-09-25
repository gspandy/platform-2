package com.raycloud.module.response;

import com.raycloud.module.pojo.StudentSchoolLog;
import com.raycloud.module.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/8/23.
 */
public class ViewStudentSchoolLogList extends ListResponse {

    public void toResponse(List<StudentSchoolLog> studentSchoolLogList){
        if(studentSchoolLogList == null){
            return;
        }
        studentDayLogList = new ArrayList<StudentDayLogListBean>();
        StudentDayLogListBean studentDayLogListBean = null;
        for(StudentSchoolLog s : studentSchoolLogList){
            studentDayLogListBean = new StudentDayLogListBean();
            studentDayLogListBean.setCreated(DateUtil.getDateTime(s.getCreated(),"yyyy-MM-dd"));
            studentDayLogListBean.setId(s.getId());
            studentDayLogListBean.setUserId(s.getUserId());
            studentDayLogListBean.setCourseName(s.getCourseName());
            studentDayLogListBean.setCondition(s.getCondition());
            studentDayLogListBean.setRemark(s.getRemark());
            studentDayLogListBean.setStudyNo(s.getStudyNo());
            studentDayLogList.add(studentDayLogListBean);
        }

    }

    /**
     * id : 1
     * userId : 1
     * studyNo : 19210001
     * courseName : 滴答
     * condition :
     * remark :
     * created :
     */

    private List<StudentDayLogListBean> studentDayLogList;



    public List<StudentDayLogListBean> getStudentDayLogList() {
        return studentDayLogList;
    }

    public void setStudentDayLogList(List<StudentDayLogListBean> studentDayLogList) {
        this.studentDayLogList = studentDayLogList;
    }


    public static class StudentDayLogListBean {
        private Long id;
        private Long userId;
        private String realName;
        private String studyNo;
        private String courseName;
        private String condition;
        private String remark;
        private String created;

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

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

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }
    }
}
