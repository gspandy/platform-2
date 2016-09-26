package com.raycloud.module.model;

import com.raycloud.module.pojo.ShopGoodsCategoryPojo;
import com.raycloud.module.pojo.ShopGoodsPojo;

import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/9/26.
 */
public class CategoryModel {

    private String name;

    private List<ShopGoodsCategoryPojo> subList;

    private List<ShopGoodsPojo> goodList;

    public List<ShopGoodsPojo> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<ShopGoodsPojo> goodList) {
        this.goodList = goodList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShopGoodsCategoryPojo> getSubList() {
        return subList;
    }

    public void setSubList(List<ShopGoodsCategoryPojo> subList) {
        this.subList = subList;
    }
}
