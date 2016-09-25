package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.module.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
@Repository
public class CourseDao extends BaseDao{


    public List<Course> getList(Course course){
        return getSqlMapClientTemplate().queryForList("Course.getList",course);
    }

    public int getCount(Course course){
        return (Integer)getSqlMapClientTemplate().queryForObject("Course.getCount",course);
    }

    /**
     * 添加
     * @param course
     */
    public void add(Course course){
        getSqlMapClientTemplate().insert("Course.add",course);
    }

    /**
     * 获取
     * @param course
     * @return
     */
    public Course get(Course course){
        return (Course)getSqlMapClientTemplate().queryForObject("Course.get",course);
    }

    /**
     * 修改
     * @param course
     * @return
     */
    public Integer update(Course course){
        return  getSqlMapClientTemplate().update("Course.update",course);
    }

    /**
     * 移除课程
     * @param course
     * @return
     */
    public Integer remove(Course course){
        return getSqlMapClientTemplate().update("Course.remove",course);
    }
}
