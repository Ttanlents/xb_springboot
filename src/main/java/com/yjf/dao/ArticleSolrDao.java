package com.yjf.dao;

import com.yjf.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * @author 余俊锋
 * @date 2020/11/19 9:34
 * @Description :继承接口，设置实例泛型和主键泛型
 */

public interface ArticleSolrDao extends SolrCrudRepository<Article,String>{


    @Highlight(fields = {"title","content"},prefix = "<font color='yellow'>",postfix = "</font>")
    HighlightPage<Article> findByKeywordsOrderByPublishDateDesc(String keywords, Pageable pageable);
}
