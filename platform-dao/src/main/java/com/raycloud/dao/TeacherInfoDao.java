package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.TeacherInfo;
import com.raycloud.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
@Repository
public class TeacherInfoDao extends BaseDao{


    public List<TeacherInfo> getList(TeacherInfo teacherinfo){
        return getSqlMapClientTemplate().queryForList("TeacherInfo.getList",teacherinfo);
    }

    /**
     * 添加
     * @param teacherinfo
     */
    public void add(TeacherInfo teacherinfo){
        getSqlMapClientTemplate().insert("TeacherInfo.add",teacherinfo);
    }

    /**
     * 获取
     * @param teacherinfo
     * @return
     */
    public TeacherInfo get(TeacherInfo teacherinfo){
        return (TeacherInfo)getSqlMapClientTemplate().queryForObject("TeacherInfo.get",teacherinfo);
    }

    /**
     * 修改
     * @param teacherinfo
     * @return
     */
    public Integer update(TeacherInfo teacherinfo){
        return  getSqlMapClientTemplate().update("TeacherInfo.update",teacherinfo);
    }

}
