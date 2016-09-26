package com.raycloud.web;


import com.raycloud.dao.ShopGoodsCategoryDao;
import com.raycloud.dao.ShopGoodsDao;
import com.raycloud.listener.InitServletContext;
import com.raycloud.module.pojo.ShopGoodsCategoryPojo;
import com.raycloud.module.pojo.ShopGoodsPojo;
import com.raycloud.module.request.GoodsAddRequest;
import com.raycloud.module.request.Request;
import com.raycloud.module.response.Response;
import com.raycloud.module.response.ViewUserList;
import com.raycloud.module.util.CategoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 网店
 * Created by linjunjie(490456661@qq.com) on 2016/9/22.
 */
@Controller
public class ShopAction extends BaseAction {

    @Resource
    private ShopGoodsDao shopGoodsDao;

    @Resource
    private ShopGoodsCategoryDao shopGoodsCategoryDao;

    /**
     * 添加商品
     * @param request
     * @return
     */
    @RequestMapping("/addGoods.do")
    public Response addGoods(GoodsAddRequest request){
        Response response = new Response(request);
        ShopGoodsPojo shopGoodsPojo = new ShopGoodsPojo();
        shopGoodsPojo.setStatus(1);
        shopGoodsPojo.setName(request.getName());
        shopGoodsPojo.setGoodsId("");//生成商品流水号
        shopGoodsPojo.setCategoryId(request.getCategoryId());
        shopGoodsPojo.setLeftId(request.getLeftId());
        shopGoodsPojo.setProgramId(request.getProgramId());
        shopGoodsPojo.setSeasonId(request.getSeasonId());
        shopGoodsPojo.setRectNum(request.getRectNum());
        shopGoodsPojo.setRectNum(request.getRectNum());

        return response;
    }

    /**
     * 根据名字模糊搜索商品
     * @param p 商品名字
     * @return
     */
    @RequestMapping("/seachGoodsByName.do")
    public String seachGoodsByName(String p,ModelMap modelMap){
        Integer pageNo = adjustPageNo();
        Integer pageSize = adjustPageSize();
        Integer startRow = (pageNo - 1) * pageSize;
        ShopGoodsPojo shopGoodsPojo = new ShopGoodsPojo();
        shopGoodsPojo.setName(p);
        shopGoodsPojo.setStartRow(startRow);
        shopGoodsPojo.setPageSize(pageSize);
        //获取列表
        List<ShopGoodsPojo> shopGoodsPojoList =  shopGoodsDao.getList(shopGoodsPojo);
        //获取总数
        Integer total = shopGoodsDao.getCount(shopGoodsPojo);
        //最大页
        Integer max = (int)Math.ceil(total * 1.0/pageSize);
        modelMap.put("goodsList",shopGoodsPojoList);
        modelMap.put("total",total);
        modelMap.put("pageNo",pageNo);
        modelMap.put("pageSize",pageSize);
        modelMap.put("max",max);
        modelMap.put("p",p);
        return "shop/search_goods";
    }

    /**
     * 首页
     * @param modelMap
     * @return
     */
    @RequestMapping("/index.html")
    public String index(ModelMap modelMap){

        modelMap.put("left", CategoryUtil.getLeft());
        modelMap.put("program", CategoryUtil.getProgram());
        return "shop/maishoujie";
    }

    /**
     * 刷新缓存
     * @param modelMap
     * @return
     */
    @RequestMapping("/indexRefresh.do")
    public String indexRefresh(ModelMap modelMap){

        InitServletContext.refresh();
        modelMap.put("left", CategoryUtil.getLeft());
        modelMap.put("program", CategoryUtil.getProgram());
        return "shop/maishoujie";
    }

}
