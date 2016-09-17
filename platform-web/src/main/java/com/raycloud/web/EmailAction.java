package com.raycloud.web;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Properties;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/9/15.
 */
public class EmailAction extends BaseAction {

    /**
     * 发送邮件
     */
    @ResponseBody
    @RequestMapping("/sendEmail")
    public static void sendEmail(){
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        senderImpl.setHost("smtp.qq.com");
        // 建立邮件消息
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        // 设置收件人，寄件人 用数组发送多个邮件
        // String[] array = new String[] {"sun111@163.com","sun222@sohu.com"};
        // mailMessage.setTo(array);
        mailMessage.setTo("3085793494@qq.com");
        mailMessage.setFrom("490456661@qq.com");
        mailMessage.setSubject(" 测试简单文本邮件发送！ ");
        mailMessage.setText(" 测试我的简单邮件发送机制！！ ");

        senderImpl.setUsername("490456661@qq.com"); // 根据自己的情况,设置username
        senderImpl.setPassword("qq63256362"); // 根据自己的情况, 设置password

        Properties prop = new Properties();

        prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
        prop.put("mail.smtp.timeout", "25000");
        senderImpl.setJavaMailProperties(prop);
        // 发送邮件
        senderImpl.send(mailMessage);

        System.out.println(" 邮件发送成功.. ");
    }

    public static void main(String[] args) {
        sendEmail();
    }

}
