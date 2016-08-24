package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.StudentInfo;
import com.raycloud.pojo.StudentSchoolLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
@Repository
public class StudentSchoolLogDao extends BaseDao{


    public List<StudentSchoolLog> getList(StudentSchoolLog studentSchoolLog){
        return getSqlMapClientTemplate().queryForList("StudentSchoolLog.getList",studentSchoolLog);
    }

    public Integer getCount(StudentSchoolLog studentSchoolLog){
        return (Integer)getSqlMapClientTemplate().queryForObject("StudentSchoolLog.getCount",studentSchoolLog);
    }

    /**
     * 添加
     * @param studentSchoolLog
     */
    public void add(StudentSchoolLog studentSchoolLog){
        getSqlMapClientTemplate().insert("StudentSchoolLog.add",studentSchoolLog);
    }

    /**
     * 获取
     * @param studentSchoolLog
     * @return
     */
    public StudentSchoolLog get(StudentSchoolLog studentSchoolLog){
        return (StudentSchoolLog)getSqlMapClientTemplate().queryForObject("StudentSchoolLog.get",studentSchoolLog);
    }

    /**
     * 修改
     * @param studentSchoolLog
     * @return
     */
    public Integer update(StudentSchoolLog studentSchoolLog){
        return  getSqlMapClientTemplate().update("StudentSchoolLog.update",studentSchoolLog);
    }

    /**
     * 逻辑删除学生每日日志（状态：删除）
     * @param studentSchoolLog
     * @return
     */
    public Integer delete(StudentSchoolLog studentSchoolLog){
        return  getSqlMapClientTemplate().delete("StudentSchoolLog.deleteById",studentSchoolLog);
    }

}
