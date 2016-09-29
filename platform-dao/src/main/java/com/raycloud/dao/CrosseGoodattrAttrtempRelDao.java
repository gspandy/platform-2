package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.module.pojo.CrosseAttroptionsPojo;
import com.raycloud.module.pojo.CrosseGoodAttroptionsRelPojo;
import com.raycloud.module.pojo.CrosseGoodattrAttrtempRelPojo;
import org.springframework.stereotype.Repository;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
@Repository
public class CrosseGoodattrAttrtempRelDao extends BaseDao {

    /**
     * 新插入一条
     * @param pojo
     */
    public void insert(CrosseGoodattrAttrtempRelPojo pojo){
        getSqlMapClientTemplate().insert("CrosseGoodattrAttrtempRel.insert",pojo);
    }

    public Integer exists(CrosseGoodattrAttrtempRelPojo pojo){
        return (Integer)getSqlMapClientTemplate().queryForObject("CrosseGoodattrAttrtempRel.exists",pojo);
    }


}
