package com.raycloud.module.response;

import com.raycloud.module.pojo.Course;
import com.raycloud.module.util.qiniu.QiniuUtils;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class ViewCourseList extends ListResponse implements Serializable{


    /**
     * id : 1
     * userId : 1
     * name :
     * picUrl :
     */
    public void toResponse(List<Course> courses){
        courseList = new ArrayList<CourseListBean>();
        CourseListBean courseListBean = null;
        for(Course course :courses){
            courseListBean = new CourseListBean();
            courseListBean.setId(course.getId());
            courseListBean.setUserId(course.getUserId());
            courseListBean.setName(course.getName());
            if(StringUtils.isNotBlank(course.getPicUrl())){
                courseListBean.setPicUrl(QiniuUtils.getInstance().getDownloadLink(course.getPicUrl()));
            }
            courseList.add(courseListBean);
        }
    }

    private List<CourseListBean> courseList;

    public List<CourseListBean> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseListBean> courseList) {
        this.courseList = courseList;
    }

    public static class CourseListBean {
        private long id;
        private long userId;
        private String name;
        private String picUrl;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
    }
}
