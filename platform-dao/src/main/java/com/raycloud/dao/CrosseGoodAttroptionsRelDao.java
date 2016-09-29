package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.module.pojo.CrosseGoodAttroptionsRelPojo;
import org.springframework.stereotype.Repository;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
@Repository
public class CrosseGoodAttroptionsRelDao extends BaseDao {

    /**
     * 新插入一条
     * @param pojo
     */
    public void insert(CrosseGoodAttroptionsRelPojo pojo){
        getSqlMapClientTemplate().insert("CrosseGoodAttroptionsRel.insert",pojo);
    }




}
