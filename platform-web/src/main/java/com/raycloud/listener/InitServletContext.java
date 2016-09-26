package com.raycloud.listener;

import com.raycloud.dao.ShopGoodsCategoryDao;
import com.raycloud.dao.ShopGoodsDao;
import com.raycloud.module.constant.WebContextConstant;
import com.raycloud.module.model.CategoryModel;
import com.raycloud.module.pojo.ShopGoodsCategoryPojo;
import com.raycloud.module.pojo.ShopGoodsPojo;
import com.raycloud.module.util.CategoryUtil;
import com.raycloud.module.util.SpringUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/3/12.
 */
public class InitServletContext implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("启动中..");
        WebContextConstant.webRealPath = servletContextEvent.getServletContext().getRealPath("/");

        refresh();
    }

    public static void refresh(){
        ShopGoodsCategoryDao shopGoodsCategoryDao = (ShopGoodsCategoryDao)SpringUtils.getBean("shopGoodsCategoryDao");
        ShopGoodsDao shopGoodsDao = (ShopGoodsDao)SpringUtils.getBean("shopGoodsDao");

        //加载所有parentId = 0的分类
        ShopGoodsCategoryPojo temp = new ShopGoodsCategoryPojo();
        temp.setParentId(0L);
        List<ShopGoodsCategoryPojo> categoryList = shopGoodsCategoryDao.getList(temp);
        CategoryModel categoryModel = null;
        List<CategoryModel> left = new ArrayList<CategoryModel>();
        List<CategoryModel> program = new ArrayList<CategoryModel>();
        List<ShopGoodsCategoryPojo> tempList = null;
        ShopGoodsPojo goodsTemp = null;
        for(ShopGoodsCategoryPojo s:categoryList){
            categoryModel = new CategoryModel();
            if("left".equals(s.getType())){
                left.add(categoryModel);
                categoryModel.setName(s.getName());
                //搜索其子分类
                temp.setParentId(s.getId());
                categoryModel.setSubList(shopGoodsCategoryDao.getList(temp));
            }else if("program".equals(s.getType())){
                program.add(categoryModel);
                categoryModel.setName(s.getName());
                //搜索其子分类
                temp.setParentId(s.getId());
                categoryModel.setSubList(shopGoodsCategoryDao.getList(temp));
                //搜索其下商品
                goodsTemp = new ShopGoodsPojo();
                goodsTemp.setStartRow(0);
                goodsTemp.setPageSize(10);
                List<Long> parentIds = new ArrayList<Long>();
                for(ShopGoodsCategoryPojo sc: categoryModel.getSubList()){
                    parentIds.add(sc.getId());
                }
                goodsTemp.setParentIds(parentIds);
                if(parentIds.size() > 0)
                    categoryModel.setGoodList(shopGoodsDao.getList(goodsTemp));
            }
        }

        //设置
        CategoryUtil.setLeft(left);
        CategoryUtil.setProgram(program);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
