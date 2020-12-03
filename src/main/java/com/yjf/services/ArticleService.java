package com.yjf.services;

import com.sun.org.apache.regexp.internal.RE;
import com.yjf.dao.ArticleDao;
import com.yjf.dao.ArticleSolrDao;
import com.yjf.dao.UserDao;
import com.yjf.entity.Article;
import com.yjf.entity.Article_;
import com.yjf.entity.PageResult;
import com.yjf.entity.User;
import com.yjf.mapper.UserMapper;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/12/2 14:54
 * @Description
 */
@Service
public class ArticleService {
    @Autowired
    ArticleSolrDao articleSolrDao;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ArticleDao articleDao;

   public  HighlightPage<Article> selectHeightPage(Integer PageCurrent, String keywords){
       return articleSolrDao.findByKeywordsOrderByPublishDateDesc(keywords, PageRequest.of(PageCurrent-1, PageResult.getPageSize()));
   }


    public List<HighlightEntry<Article>> selectListPage( HighlightPage<Article> page){
        List<HighlightEntry<Article>> list = page.getHighlighted(); //包含高亮部分的goodsList
        for (HighlightEntry<Article> entry : list) {
            //将entry的属性，凡是高亮的都替换
            Article article = entry.getEntity();
            for (HighlightEntry.Highlight highlight : entry.getHighlights()) {
                if (highlight.getField().getName().equals("title")){
                    article.setTitle(highlight.getSnipplets().get(0));
                }else if (highlight.getField().getName().equals("content")){
                    article.setContent(highlight.getSnipplets().get(0));
                }
            }
        }
        return list;
    }

    public Page<Article> selectAllPage(Integer pageCurrent) {
     return   articleSolrDao.findAll(PageRequest.of(pageCurrent-1,PageResult.getPageSize(), Sort.by(Sort.Direction.DESC,"publishDate")));
    }

    public void addArticle(Article_ article) {
       articleDao.save(article);
    }

    public void addArticleForSolr(Article solr) {
       articleSolrDao.save(solr);
    }

    @Transactional
    public void updateBrowCount(Integer id) {
       articleDao.updateBrowCount(id+"");
    }

    public List<User> tooCollection(Integer loginUserId, Integer articleId) {
     return userMapper.tooCollection(loginUserId,articleId);
    }

    public Integer collectCount(Integer id) {
       return articleDao.countById(id);
    }


    public Article_ findArticleById(Integer id) {
       return  articleDao.getOne(String.valueOf(id));
    }

    public Boolean isFavorite(Integer loginUserId, Integer articleId) {
       return articleDao.isFavorite(loginUserId,articleId)>0?true:false;
    }

    @Transactional
    public Boolean changeCollectArticle(Integer userId, Integer id) {
        if (isFavorite(userId, id)) {
            articleDao.deleteFavorite(userId, id);
            return false;
        }
        articleDao.addFavorite(userId, id);
        return true;
    }

    public Page<Article_> myFavoriteArticle(Integer loginUserId,String title,Integer pageCurrent) {
     return   articleDao.myFavoriteArticle(loginUserId,"%"+title+"%",PageRequest.of(pageCurrent-1,PageResult.getPageSize(),Sort.by(Sort.Direction.DESC,"publishDate")));
    }
}
