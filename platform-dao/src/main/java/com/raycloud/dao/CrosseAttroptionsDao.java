package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.module.pojo.CrosseAttroptionsPojo;
import com.raycloud.module.pojo.CrosseGoodTypePojo;
import org.springframework.stereotype.Repository;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
@Repository
public class CrosseAttroptionsDao extends BaseDao {

    /**
     * 新插入一条
     * @param pojo
     */
    public void insert(CrosseAttroptionsPojo pojo){
        getSqlMapClientTemplate().insert("CrosseAttroptions.insert",pojo);
    }

    public Integer exists(CrosseAttroptionsPojo pojo){
        return (Integer)getSqlMapClientTemplate().queryForObject("CrosseAttroptions.exists",pojo);
    }


}
