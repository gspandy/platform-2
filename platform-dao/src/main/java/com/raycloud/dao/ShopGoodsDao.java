package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.module.pojo.ShopGoodsPojo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
@Repository
public class ShopGoodsDao extends BaseDao{


    public List<ShopGoodsPojo> getList(ShopGoodsPojo shopGoodsPojo){
        return getSqlMapClientTemplate().queryForList("ShopGoods.getList",shopGoodsPojo);
    }

    public int getCount(ShopGoodsPojo shopGoodsPojo){
        return (Integer)getSqlMapClientTemplate().queryForObject("ShopGoods.getCount",shopGoodsPojo);
    }

    /**
     * 添加
     * @param shopGoodsPojo
     */
    public void insert(ShopGoodsPojo shopGoodsPojo){
        getSqlMapClientTemplate().insert("ShopGoods.insert",shopGoodsPojo);
    }

    /**
     * 获取
     * @param shopGoodsPojo
     * @return
     */
    public ShopGoodsPojo get(ShopGoodsPojo shopGoodsPojo){
        return (ShopGoodsPojo)getSqlMapClientTemplate().queryForObject("ShopGoods.get",shopGoodsPojo);
    }

}
