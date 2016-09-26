package com.raycloud.module.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 用来获取容器中的bean的帮助类，有时候需要用到
 * Created by linjunjie(490456661@qq.com) on 2016/4/1.
 */
@Component
public class SpringUtils implements ApplicationContextAware{

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }
}
