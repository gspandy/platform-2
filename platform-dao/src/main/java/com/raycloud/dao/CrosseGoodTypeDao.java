package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.module.pojo.Category;
import com.raycloud.module.pojo.CrosseGoodTypePojo;
import org.springframework.stereotype.Repository;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
@Repository
public class CrosseGoodTypeDao extends BaseDao {

    /**
     * 新插入一条
     * @param pojo
     */
    public void insert(CrosseGoodTypePojo pojo){
        getSqlMapClientTemplate().insert("CrosseGoodType.insert",pojo);
    }


    public Integer exists(CrosseGoodTypePojo pojo){
        return (Integer)getSqlMapClientTemplate().queryForObject("CrosseGoodType.exists",pojo);
    }




}
