package com.raycloud.module.response;

import com.raycloud.module.pojo.Article;
import com.raycloud.module.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/7/24.
 */
public class ViewArticleList extends ListResponse {

    public void toResponse(List<Article> articles){
        articleList = new ArrayList<ArticleListBean>();
        ArticleListBean bean = null;
        for(Article a : articles){
            bean = new ArticleListBean();
            bean.setId(a.getId());
            bean.setUsername(a.getUsername());
            bean.setTitle(a.getTitle());
            bean.setContent(a.getContent());
            bean.setHeadPhotoUrl(a.getHeadPhotoUrl());
            bean.setReadNum(a.getReadNum());
            bean.setAuthor(a.getAuthor());
            bean.setCategoryId(a.getCategoryId());
            bean.setCategory(a.getCategory());
            bean.setBoardNum(a.getBoardNum());
            bean.setCreated(DateUtil.getDateTime(a.getCreated(),"yyyy-MM-dd"));


            articleList.add(bean);
        }
    }

    private List<ArticleListBean> articleList;

    public List<ArticleListBean> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleListBean> articleList) {
        this.articleList = articleList;
    }

    public static class ArticleListBean {
        private Long id;
        private String username;
        private String author;
        private String title;
        private String content;
        private String headPhotoUrl;
        private Long readNum;
        private Integer boardNum;
        private String category;
        private Long categoryId;
        private String created;

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

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
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

        public Integer getBoardNum() {
            return boardNum;
        }

        public void setBoardNum(Integer boardNum) {
            this.boardNum = boardNum;
        }

        public Long getReadNum() {
            return readNum;
        }

        public void setReadNum(Long readNum) {
            this.readNum = readNum;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }
    }
}
