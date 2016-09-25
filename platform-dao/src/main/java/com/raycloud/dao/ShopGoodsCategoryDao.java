package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.module.pojo.ShopGoodsCategoryPojo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
@Repository
public class ShopGoodsCategoryDao extends BaseDao{


    public List<ShopGoodsCategoryPojo> getList(ShopGoodsCategoryPojo shopGoodsCategoryPojo){
        return getSqlMapClientTemplate().queryForList("ShopGoodsCategory.getList",shopGoodsCategoryPojo);
    }

    public int getCount(ShopGoodsCategoryPojo shopGoodsCategoryPojo){
        return (Integer)getSqlMapClientTemplate().queryForObject("ShopGoodsCategory.getCount",shopGoodsCategoryPojo);
    }

    /**
     * 添加
     * @param shopGoodsCategoryPojo
     */
    public void insert(ShopGoodsCategoryPojo shopGoodsCategoryPojo){
        getSqlMapClientTemplate().insert("ShopGoodsCategory.insert",shopGoodsCategoryPojo);
    }

    /**
     * 获取
     * @param shopGoodsCategoryPojo
     * @return
     */
    public ShopGoodsCategoryPojo get(ShopGoodsCategoryPojo shopGoodsCategoryPojo){
        return (ShopGoodsCategoryPojo)getSqlMapClientTemplate().queryForObject("ShopGoodsCategory.get",shopGoodsCategoryPojo);
    }

}
