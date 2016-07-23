package com.raycloud.request;

import com.sun.istack.internal.NotNull;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/9.
 */
public class ArticleAddRequest extends Request {

    private Long id;
    private String username;
    private String title;
    private String content;
    private MultipartFile headPhotoUrl;
    private String author;
    private Long categoryId;

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

    public MultipartFile getHeadPhotoUrl() {
        return headPhotoUrl;
    }

    public void setHeadPhotoUrl(MultipartFile headPhotoUrl) {
        this.headPhotoUrl = headPhotoUrl;
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
}
