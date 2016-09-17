package com.raycloud.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/9/4.
 */
public class SequenceUtil {

    private static final int orderNo = 1000000; //最长100万长度
    private static long currentNo = 0; //当前长度
    private static final int MAX_INTEGER_DIGITS = 7; //最大整数位
    private static final int MIN_INTEGER_DIGITS = 7; //最小整数位
    /**
     * 生成序列号 平台号(渠道170) + 注册日期(20160904) + 递增orderNo
     */
    public static void generateOrderNo(String currentNoStr){
        //【1】获取平台号
        String platformCode = "170";
        //【2】获取注册日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        //【3】递增，需要加资源锁,并且补充0
        //long currentNo = Long.parseLong(currentNoStr) + 1;
        currentNo += 1;//数据库的话  update  currentNo+=1 一下。
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        //设置最大整数位
        numberFormat.setMaximumIntegerDigits(MAX_INTEGER_DIGITS);
        //设置最小整数位
        numberFormat.setMinimumIntegerDigits(MIN_INTEGER_DIGITS);

        String currentNoStrNext = numberFormat.format(currentNo);
        //【4】生成序列号
        StringBuilder sequence = new StringBuilder(platformCode)
                .append(date)
                .append(currentNoStrNext);
        System.out.println("您生成的序列号为"+sequence.toString());
    }

    public static void main(String[] args) {
        for(int i =0;i<=1000;i++) {
            generateOrderNo("500");
        }
    }
}
