package com.raycloud.pojo;

import com.alibaba.fastjson.JSONObject;
import com.raycloud.pojo.common.BasePojo;
import com.raycloud.util.DataBaseUtil;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户信息表
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
public class User extends BasePojo implements Serializable {


    private static final long serialVersionUID = -7677066744837758920L;
    /**
     * 自增ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 分表的路由信息,有DBConfig这个类转成json字符串，存储在这个字段
     * 比如：{"activityDBId":1}
     *
     */
    private String configRule;
    private DbConfig dbConfig;
    private String owner;
    private String phone;
    private String institution;
    private String desc;
    private String businessCode;
    private String addressCode;
    private String addressDetail;
    private String logoPicUrl;
    private String invitationCode;
    private String contactHotline;
    private Integer authenticate;
    private Date created;
    private Date modified;
    private Integer status;


    /**
     * 是否根据id排序
     * @param isAsc
     * @return
     */
    public User orderById(boolean isAsc){
        orderFields.add(new OrderField("id",isAsc?"ASC":"DESC"));
        return this;
    }

    public User orderByUsername(boolean isAsc){
        orderFields.add(new OrderField("username",isAsc?"ASC":"DESC"));
        return this;
    }

    /**====================结束**/

    public static class DbConfig{
        public static final int ARTICLE_NUM = 5;
        public static final int USER_CATEGORY_RELATION_NUM = 5;
        private Integer articleDbId;
        private Integer userCategoryRelationDbId;
        public DbConfig(){

        }
        public DbConfig(Long id){
            this.articleDbId = DataBaseUtil.getDBId(id, ARTICLE_NUM);
            this.userCategoryRelationDbId = DataBaseUtil.getDBId(id, USER_CATEGORY_RELATION_NUM);
        }

        public Integer getArticleDbId() {
            return articleDbId;
        }

        public void setArticleDbId(Integer articleDbId) {
            this.articleDbId = articleDbId;
        }

        public Integer getUserCategoryRelationDbId() {
            return userCategoryRelationDbId;
        }

        public void setUserCategoryRelationDbId(Integer userCategoryRelationDbId) {
            this.userCategoryRelationDbId = userCategoryRelationDbId;
        }
    }

    public static void main(String args[]){
        String db = "{\"articleDbId\":2}";
        DbConfig dbConfig1 = JSONObject.parseObject(db, DbConfig.class);
        System.out.println(dbConfig1.getArticleDbId());
    }

    public List<Long> getKeys() {
        return keys;
    }

    public void setKeys(List<Long> keys) {
        this.keys = keys;
    }

    public List<OrderField> getOrderFields() {
        return orderFields;
    }

    public void setOrderFields(List<OrderField> orderFields) {
        this.orderFields = orderFields;
    }


    public String getContactHotline() {
        return contactHotline;
    }

    public void setContactHotline(String contactHotline) {
        this.contactHotline = contactHotline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getConfigRule() {
        return configRule;
    }

    public void setConfigRule(String configRule) {
        this.configRule = configRule;
    }

    public DbConfig getDbConfig() {
        if(dbConfig == null){
            synchronized (DbConfig.class){
                if(dbConfig == null && StringUtils.isNotBlank(configRule)){
                    dbConfig = JSONObject.parseObject(configRule,DbConfig.class);
                }
            }
        }
        return dbConfig;
    }

    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getLogoPicUrl() {
        return logoPicUrl;
    }

    public void setLogoPicUrl(String logoPicUrl) {
        this.logoPicUrl = logoPicUrl;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Integer authenticate) {
        this.authenticate = authenticate;
    }
}
