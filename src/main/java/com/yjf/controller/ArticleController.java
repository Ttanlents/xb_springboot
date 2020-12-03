package com.yjf.controller;

import com.yjf.entity.*;
import com.yjf.services.ArticleService;
import com.yjf.utils.LoginUserUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author 余俊锋
 * @date 2020/12/2 15:05
 * @Description
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/selectPage/{pageCurrent}", method = RequestMethod.GET)
    @ResponseBody
    public Result selectPage(@PathVariable Integer pageCurrent,String keyWords) {
        if (keyWords==null||keyWords.equals("")){
         Page<Article> page=  articleService.selectAllPage(pageCurrent);
            PageResult<Article> pageResult = new PageResult<>(page.getTotalPages(), page.getContent());
            return new Result(true, "查询成功", pageResult);
        }

        HighlightPage<Article> page = articleService.selectHeightPage(pageCurrent, keyWords);
        List<HighlightEntry<Article>> entries = articleService.selectListPage(page);
        ArrayList<Article> list = new ArrayList<>();
        for (HighlightEntry<Article> entry : entries) {
            list.add(entry.getEntity());
        }
        PageResult<Article> pageResult = new PageResult<>(page.getTotalPages()==0?1:page.getTotalPages(),list);
        return new Result(true, "查询成功", pageResult);
    }

    @PostMapping(value = "/addArticle")
    @ResponseBody
    public Result addArticle(@RequestBody Article_ article) {
        User loginUser = LoginUserUtils.getLoginUser();
        article.setBrowseCount(0);
        article.setPublishDate(new Date());
        article.setPublishRealName(loginUser.getRealName());
        article.setUserId(loginUser.getId());

        articleService.addArticle(article); //保存到数据库

        Article solr = new Article();
        BeanUtils.copyProperties(article,solr);
        articleService.addArticleForSolr(solr);//保存到solr
        return new Result(true, "发布成功",null);
    }

    @PostMapping(value = "/getArticle/{id}")
    @ResponseBody
    public Result getArticle(@PathVariable Integer id,@RequestBody Article_ article_) {
        User loginUser = LoginUserUtils.getLoginUser();
        if (loginUser.getId()!=article_.getUserId()){
            articleService.updateBrowCount(id);
        }
        Map<String,Object> map=new HashMap<>();
        Article_ article= articleService.findArticleById(id);
        List<User> userList=articleService.tooCollection(loginUser.getId(),id);
        Integer  count=articleService.collectCount(id);
        Boolean isFavorite=articleService.isFavorite(loginUser.getId(),id);
        System.out.println(isFavorite);
        map.put("userList",userList);
        map.put("count",count);
        map.put("article",article);
        map.put("isFavorite",isFavorite);
        return new Result(true, "发布成功",map);
    }

    @PutMapping(value = "/changeCollectArticle/{id}")
    @ResponseBody
    public Result changeCollectArticle(@PathVariable Integer id) {
        Integer userId = LoginUserUtils.getLoginUserId();
        Boolean flag=articleService.changeCollectArticle(userId,id);
        if (flag){
            return new Result(true, "收藏成功",null);
        }
        return new Result(true, "取消收藏成功",null);
    }

    @GetMapping(value = "/myFavoriteArticle/{pageCurrent}")
    @ResponseBody
    public Result myFavoriteArticle(@PathVariable Integer pageCurrent, String title) {
        if (title==null){
            title="";
        }
        Integer loginUserId = LoginUserUtils.getLoginUserId();
        Page<Article_> page= articleService.myFavoriteArticle(loginUserId,title,pageCurrent);
        PageResult<Article_> pageResult = new PageResult<>(page.getTotalPages(), page.getContent());
        return new Result(true, "查询成功",pageResult);
    }



}
