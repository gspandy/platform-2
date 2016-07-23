package com.raycloud.pojo;

import com.alibaba.fastjson.JSONObject;
import com.raycloud.pojo.common.BasePojo;
import com.raycloud.util.DataBaseUtil;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
public class Article extends BasePojo implements Serializable {

    private static final long serialVersionUID = -8828751498987592013L;
    private Long id;
    private String configRule;//json路由规则,一般是对留言信息的路由
    private String username;
    private String title;
    private String content;
    private String headPhotoUrl;//文章头部图片
    private Long readNum;//阅读量
    private String author;//作者
    private Long categoryId;//分类id
    private String category;//分类名
    private Integer boardNum;//留言数(包括子留言)
    private Date created;//创建时间
    private Date modified;//修改时间
    private Integer status;//状态 1 可用

    /**结束 ====*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigRule() {
        return configRule;
    }

    public void setConfigRule(String configRule) {
        this.configRule = configRule;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadPhotoUrl() {
        return headPhotoUrl;
    }

    public void setHeadPhotoUrl(String headPhotoUrl) {
        this.headPhotoUrl = headPhotoUrl;
    }

    public Long getReadNum() {
        return readNum;
    }

    public void setReadNum(Long readNum) {
        this.readNum = readNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(Integer boardNum) {
        this.boardNum = boardNum;
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
}
