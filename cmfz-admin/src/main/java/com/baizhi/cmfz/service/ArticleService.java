package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

/**
 * Created by HP on 2018/7/8.
 */
public interface ArticleService {
    /**
     * 添加文章
     * @param article
     * @return
     */
    public int addArticle(Article article);
}
