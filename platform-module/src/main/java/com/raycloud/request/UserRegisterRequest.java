package com.raycloud.request;

import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/4/28.
 */
public class UserRegisterRequest extends Request {

    /**幼儿园项目**/
    //机构前缀标识
    private String preNo;
    //联系人
    private String owner;
    //手机号
    private String phone;
    //机构名称
    private String institution;
    //用户名
    private String username;
    //密码
    private String password;
    /**---截止---**/


    private String nick;

    private String address;

    private Date birthday;

    public String getPreNo() {
        return preNo;
    }

    public void setPreNo(String preNo) {
        this.preNo = preNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
