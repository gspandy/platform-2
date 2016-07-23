package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.Article;
import com.raycloud.pojo.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
@Repository
public class ArticleDao extends BaseDao{


    public List<Article> getList(Article article){
        return getSqlMapClientTemplate().queryForList("Article.getList",article);
    }

    public int getCount(Article article){
        return (Integer)getSqlMapClientTemplate().queryForObject("Article.getCount",article);
    }

    /**
     * 添加
     * @param article
     */
    public void insert(Article article){
        getSqlMapClientTemplate().insert("Article.insert",article);
    }

    /**
     * 获取
     * @param article
     * @return
     */
    public Article get(Article article){
        return (Article)getSqlMapClientTemplate().queryForObject("Article.get",article);
    }

    /**
     * 修改文章的阅读数或留言数
     * @param article
     * @return
     */
    public Integer updateNum(Article article){
        return  getSqlMapClientTemplate().update("Article.updateNum",article);
    }

    /**
     * 移除
     * @param article
     * @return
     */
    public Integer remove(Article article){
        return getSqlMapClientTemplate().update("Article.remove",article);
    }
}
