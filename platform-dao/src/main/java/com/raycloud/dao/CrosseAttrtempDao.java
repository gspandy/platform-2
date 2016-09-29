package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.module.pojo.CrosseAttroptionsPojo;
import com.raycloud.module.pojo.CrosseAttrtempPojo;
import com.raycloud.module.pojo.CrosseGoodTypePojo;
import org.springframework.stereotype.Repository;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
@Repository
public class CrosseAttrtempDao extends BaseDao {

    /**
     * 新插入一条
     * @param pojo
     */
    public void insert(CrosseAttrtempPojo pojo){
        getSqlMapClientTemplate().insert("CrosseAttrtemp.insert",pojo);
    }



    public Integer exists(CrosseAttrtempPojo pojo){
        return (Integer)getSqlMapClientTemplate().queryForObject("CrosseAttrtemp.exists",pojo);
    }
}
