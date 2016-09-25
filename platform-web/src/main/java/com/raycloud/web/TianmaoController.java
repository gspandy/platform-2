package com.raycloud.web;

import com.alibaba.fastjson.JSON;

import com.raycloud.module.util.ParentModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    private static WebDriver driver = null;

    public static void main(String[] args) {
        try {
            pull();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从天猫拉取数据
     * @return
     */
    @RequestMapping("/pull.do")
    public static String pull()throws Exception{

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
        int count = 0;
        //设置驱动
        System.getProperties().setProperty("webdriver.firefox.bin","E:\\火狐\\firefox.exe");
        //打开火狐浏览器
        driver = new FirefoxDriver();

        for(ParentModel.Parent p : array){
            firstNavBeans = p.getFirstNav();
            for(ParentModel.FirstNavBean f : firstNavBeans){
                secondNavBeans = f.getSecondNav();
                for(ParentModel.SecondNavBean s : secondNavBeans){
                    //获取url
                    _execute("https:"+ URLDecoder.decode(s.getHref(), "gbk"));
                    count ++;

                }

            }
            break;
        }

        return "index";
    }

    public static void _execute(String url)throws Exception{

        long waitLoadBaseTime = 1000;
        int waitLoadRandomTime = 1000;
        Random random = new Random(System.currentTimeMillis());
        //自动打开页面url
        driver.get(url);
        if(driver.getCurrentUrl().contains("https://login.taobao.com/member/login.jhtml")){

            //判断是否是登陆页面，是的话则先登陆

            driver.findElement(By.id("J_Quick2Static")).click();
            WebElement username = driver.findElement(By.id("TPL_username_1"));
            username.sendKeys("15867121265");
            WebElement password = driver.findElement(By.id("TPL_password_1"));
            password.sendKeys("qq6325636");
            Thread.sleep(1500);
            driver.findElement(By.id("J_SubmitStatic")).click();
        }
        System.out.println("准备启动");
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
        /**以下获得数据**/
        List<WebElement> keys = driver.findElements(By.className("attrKey"));
        List<WebElement> values = driver.findElements(By.className("attrValues"));
        int parentId = 1;
        List<WebElement> aTag = null;
        for(int i = 0; i < keys.size() ; i++){
            //插入数据库中
            System.out.println("key:" + keys.get(i).getText());
            aTag = values.get(i).findElements(By.cssSelector("ul>li>a"));
            for(int j=0;j<aTag.size();j++) {
                System.out.println(" value:"+aTag.get(j).getText().replaceAll("<([^>]*)>",""));
            }
            //key - >type, value - >name,
        }


    }


}
