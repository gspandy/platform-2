package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.module.pojo.CrosseAttrtempPojo;
import com.raycloud.module.pojo.CrosseGoodattrPojo;
import org.springframework.stereotype.Repository;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
@Repository
public class CrosseGoodattrDao extends BaseDao {

    /**
     * 新插入一条
     * @param pojo
     */
    public void insert(CrosseGoodattrPojo pojo){
        getSqlMapClientTemplate().insert("CrosseGoodattr.insert",pojo);
    }


    public Integer exists(CrosseGoodattrPojo pojo){
        return (Integer)getSqlMapClientTemplate().queryForObject("CrosseGoodattr.exists",pojo);
    }

}
