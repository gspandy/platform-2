package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.StudentInfo;
import com.raycloud.pojo.TeacherInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
@Repository
public class StudentInfoDao extends BaseDao{


    public List<StudentInfo> getList(StudentInfo studentInfo){
        return getSqlMapClientTemplate().queryForList("StudentInfo.getList",studentInfo);
    }

    public Integer getCount(StudentInfo studentInfo){
        return (Integer)getSqlMapClientTemplate().queryForObject("StudentInfo.getCount",studentInfo);
    }

    /**
     * 添加
     * @param studentInfo
     */
    public void add(StudentInfo studentInfo){
        getSqlMapClientTemplate().insert("StudentInfo.add",studentInfo);
    }

    /**
     * 获取
     * @param studentInfo
     * @return
     */
    public StudentInfo get(StudentInfo studentInfo){
        return (StudentInfo)getSqlMapClientTemplate().queryForObject("StudentInfo.get",studentInfo);
    }

    /**
     * 修改
     * @param studentInfo
     * @return
     */
    public Integer update(StudentInfo studentInfo){
        return  getSqlMapClientTemplate().update("StudentInfo.update",studentInfo);
    }

    /**
     * 逻辑删除学生（状态：退学）
     * @param studentInfo
     * @return
     */
    public Integer delete(StudentInfo studentInfo){
        return  getSqlMapClientTemplate().delete("StudentInfo.deleteById",studentInfo);
    }

}
