package com.raycloud.web.test;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/3/24.
 */
public class BaseTest {

    public static void main(String args[]){
       String str = "<p>[haha]<img alt=\"\" src=\"http://i3.17173.itc.cn/2016/lol/2016/05/18/pbe0518_07.jpg\" style=\"height:73px; width:200px\" />炸弹先驱吉格斯</p>\n";
       //Pattern pattern = Pattern.compile("img");
       //Matcher matcher =  pattern.matcher(str);
        //str = matcher.replaceFirst(str);
        str = str.replaceAll("<([^>]*)>","");
        //str = str.replaceAll("[<a-zA-Z\"\\s=/:.;>?0-9_]*","");
        System.out.println(str);
    }

}
