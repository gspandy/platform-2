package com.raycloud.web;

import com.alibaba.fastjson.JSON;

import com.raycloud.dao.*;
import com.raycloud.module.pojo.*;
import com.raycloud.module.util.ParentModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.List;
import java.util.Random;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/9/25.
 */
@Controller
public class TianmaoController extends BaseAction {

    @Autowired
    private CrosseGoodattrAttrtempRelDao crosseGoodattrAttrtempRelDao;

    @Autowired
    private CrosseGoodTypeDao crosseGoodTypeDao;

    @Autowired
    private CrosseGoodAttrtempRelDao crosseGoodAttrtempRelDao;

    @Autowired
    private CrosseGoodAttroptionsRelDao crosseGoodAttroptionsRelDao;

    @Autowired
    private CrosseAttroptionsDao crosseAttroptionsDao;

    @Autowired
    private CrosseAttrtempDao crosseAttrtempDao;

    @Autowired
    private CrosseGoodattrDao crosseGoodattrDao;


    private static WebDriver driver = null;

    //模板id
    private static int attrTempId = 0;

    //属性值id
    private static int attroptionsId = 1;

    //属性id
    private static int goodattrId = 1;

    public static void main(String[] args) {
       /* try {
            pull();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        /*try {
            alipayPull();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 从天猫拉取数据
     * @return
     */
    @RequestMapping("/pull.do")
    public String pull()throws Exception{

        String str ="";
        File file = new File("D://new2.txt");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file),"utf-8")
        );
        str = br.readLine();
        ParentModel parentModel = JSON.parseObject(str, ParentModel.class);
        List<ParentModel.Parent> array = parentModel.getArray();
        List<ParentModel.FirstNavBean> firstNavBeans = null;
        List<ParentModel.SecondNavBean> secondNavBeans = null;
        int count = 1;
        //设置驱动
        System.getProperties().setProperty("webdriver.firefox.bin","G:\\firefox33\\firefox.exe");
        //打开火狐浏览器
        driver = new FirefoxDriver();

        CrosseGoodTypePojo oneGoodTypePojo = null,twoGoodTypePojo = null,threeGoodTypePojo = null;
        for(ParentModel.Parent p : array){
            //【1】一级类目
            oneGoodTypePojo = new CrosseGoodTypePojo();
            firstNavBeans = p.getFirstNav();
            oneGoodTypePojo.setId(count++);
            oneGoodTypePojo.setParentId(-1);
            oneGoodTypePojo.setName(p.getTitle());
            if(crosseGoodTypeDao.exists(oneGoodTypePojo) == 0) {
                crosseGoodTypeDao.insert(oneGoodTypePojo);
            }

            for(ParentModel.FirstNavBean f : firstNavBeans){
                //【2】二级类目
                twoGoodTypePojo = new CrosseGoodTypePojo();
                twoGoodTypePojo.setParentId(oneGoodTypePojo.getId());
                twoGoodTypePojo.setId(count++);
                twoGoodTypePojo.setName(f.getTitle());
                if(crosseGoodTypeDao.exists(twoGoodTypePojo) == 0) {
                    crosseGoodTypeDao.insert(twoGoodTypePojo);
                }
                secondNavBeans = f.getSecondNav();
                for(ParentModel.SecondNavBean s : secondNavBeans){
                    //【3】三级类目
                    threeGoodTypePojo = new CrosseGoodTypePojo();
                    threeGoodTypePojo.setParentId(twoGoodTypePojo.getId());
                    threeGoodTypePojo.setId(count++);
                    threeGoodTypePojo.setName(s.getTitle());
                    if(crosseGoodTypeDao.exists(threeGoodTypePojo) == 0) {
                        crosseGoodTypeDao.insert(threeGoodTypePojo);
                    }
                    //获取url
                    _execute("https:"+ URLDecoder.decode(s.getHref(), "gbk"),s.getTitle(),threeGoodTypePojo.getId());


                }

            }
            break;
        }

        return "index";
    }

    public void _execute(String url,String tempName,Integer typeId)throws Exception{
        attrTempId++;

        long waitLoadBaseTime = 1000;
        int waitLoadRandomTime = 1000;
        Random random = new Random(System.currentTimeMillis());
        //自动打开页面url
        driver.get(url);
        if(driver.getCurrentUrl().contains("https://login.taobao.com/member/login.jhtml")){

            //判断是否是登陆页面，是的话则先登陆
            Thread.sleep(1500);
            driver.findElement(By.id("J_Quick2Static")).click();
            WebElement username = driver.findElement(By.id("TPL_username_1"));
            username.sendKeys("15867121265");
            Thread.sleep(1000);
            WebElement password = driver.findElement(By.id("TPL_password_1"));
            password.sendKeys("qq6325636");
            Thread.sleep(1500);
            driver.findElement(By.id("J_SubmitStatic")).click();
        }
        System.out.println("准备启动");
        Thread.sleep(3000);
        //点击更多查询选项,必须得非隐藏才可以点击，否则模拟失败
        List<WebElement> jmores = driver.findElements(By.className("j_MoreAttrs"));
        for(WebElement e:jmores){
            if(e.isDisplayed())
                e.click();
        }
        //点击更多按钮
        jmores = driver.findElements(By.className("j_More"));
        for(WebElement e:jmores){
            if(e.isDisplayed())
                e.click();
        }

        //【1.】创建属性模板
        CrosseAttrtempPojo attrTemp = new CrosseAttrtempPojo();
        attrTemp.setId(attrTempId );
        attrTemp.setAttrtempName(tempName);
        attrTemp.setGoodTypeId(typeId);
        if(crosseAttrtempDao.exists(attrTemp) == 0) {
            crosseAttrtempDao.insert(attrTemp);
        }

        //属性
        CrosseGoodattrPojo goodattrPojo = null;
        //属性与模板关联
        CrosseGoodattrAttrtempRelPojo goodattrAttrtempRelPojo = null;

        //属性与属性值关联
        CrosseGoodAttroptionsRelPojo goodAttroptionsRelPojo = null;
        //属性值
        CrosseAttroptionsPojo crosseAttroptionsPojo = null;

        /**以下获得数据**/
        List<WebElement> keys = driver.findElements(By.className("attrKey"));
        List<WebElement> values = driver.findElements(By.className("attrValues"));
        int parentId = 1;
        List<WebElement> aTag = null;
        for(int i = 0; i < keys.size() ; i++){
            //【2】关联属性模板，并且插入属性
            System.out.println("key:" + keys.get(i).getText());
            goodattrPojo = new CrosseGoodattrPojo();
            goodattrPojo.setId(goodattrId ++);
            goodattrPojo.setAttrName(keys.get(i).getText());
            goodattrPojo.setAttrType("商品");
            goodattrPojo.setOptional("1");
            goodattrPojo.setPricing("1");
            if(crosseGoodattrDao.exists(goodattrPojo) == 0) {
                crosseGoodattrDao.insert(goodattrPojo);
            }
            goodattrAttrtempRelPojo = new CrosseGoodattrAttrtempRelPojo();
            goodattrAttrtempRelPojo.setGoodaddrId(goodattrPojo.getId());
            goodattrAttrtempRelPojo.setAttrtempId(attrTemp.getId());
            if(crosseGoodattrAttrtempRelDao.exists(goodattrAttrtempRelPojo) == 0) {
                crosseGoodattrAttrtempRelDao.insert(goodattrAttrtempRelPojo);
            }
            //
            aTag = values.get(i).findElements(By.cssSelector("ul>li>a"));
            for(int j=0;j<aTag.size();j++) {
                //【3】关联属性，插入属性值

                crosseAttroptionsPojo = new CrosseAttroptionsPojo();
                crosseAttroptionsPojo.setId(attroptionsId++);
                crosseAttroptionsPojo.setGoodAttrId(goodattrPojo.getId());
                crosseAttroptionsPojo.setOptionType("text");
                crosseAttroptionsPojo.setOptionValue(aTag.get(j).getText().replaceAll("<([^>]*)>",""));
                crosseAttroptionsPojo.setResourceId(-1);
                if(crosseAttroptionsDao.exists(crosseAttroptionsPojo) == 0) {
                    crosseAttroptionsDao.insert(crosseAttroptionsPojo);
                }
                System.out.println(" ★★★★★★★★★VALUE ★★:"+aTag.get(j).getText().replaceAll("<([^>]*)>",""));
            }
            //key - >type, value - >name,
        }


    }


    /**
     * 拉取支付宝数据
     */
    public static void alipayPull()throws Exception{
        //设置驱动
        System.getProperties().setProperty("webdriver.firefox.bin","G:\\firefox33\\firefox.exe");
        //打开火狐浏览器
        driver = new FirefoxDriver();
        //打开链接
        driver.get("https://consumeprod.alipay.com/record/standard.htm");
        System.out.println("准备启动 ");
        if(driver.getCurrentUrl().contains("https://auth.alipay.com/login/index.htm")){
            //登录验证
            driver.findElement(By.id("J-input-user")).sendKeys("15675205364");
            Thread.sleep(1000);
            driver.findElement(By.id("password_rsainput")).sendKeys("qq6325636");
            Thread.sleep(1000);
            driver.findElement(By.id("J-login-btn")).click();
        }
        Thread.sleep(1000);

        WebElement e = driver.findElement(By.id("tradeRecordsIndex"));
        System.out.println(e.getText());

    }

    public void _executeAlipay(String url)throws Exception{
        //打开链接
        driver.get("https://consumeprod.alipay.com/record/standard.htm");
        System.out.println("准备启动 ");
        if(driver.getCurrentUrl().contains("https://auth.alipay.com/login/index.htm")){
            //登录验证
            driver.findElement(By.id("J-input-user")).sendKeys("");
            Thread.sleep(1000);
            driver.findElement(By.id("password_rsainput")).sendKeys("");
            Thread.sleep(1000);
            driver.findElement(By.id("J-login-btn")).click();
        }
        Thread.sleep(1000);
    }

}
