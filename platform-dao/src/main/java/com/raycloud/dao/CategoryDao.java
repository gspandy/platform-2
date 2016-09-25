package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.module.pojo.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
@Repository
public class CategoryDao extends BaseDao {

    public void insert(Category category){
        getSqlMapClientTemplate().insert("Category.insert",category);
    }

    public Category get(Category category){
        return (Category)getSqlMapClientTemplate().queryForObject("Category.get",category);
    }


}
