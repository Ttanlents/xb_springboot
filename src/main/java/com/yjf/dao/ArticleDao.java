package com.yjf.dao;

import com.yjf.entity.Article_;
import com.yjf.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/12/2 17:10
 * @Description
 */
public interface ArticleDao extends JpaRepository<Article_,String> {




    @Query("update Article_ a set a.browseCount=a.browseCount+1 where a.id=?1")
    @Modifying
    void updateBrowCount(String id);



    @Query("select count(1) from Favorite f where f.aId=?1")
    Integer countById(Integer id);

    @Query("select count(1) from Favorite f where f.uId=?1 and f.aId=?2")
    Integer isFavorite(Integer loginUserId, Integer articleId) ;

    @Query("delete from Favorite f where f.uId=?1 and f.aId=?2 ")
    @Modifying
    void deleteFavorite(Integer userId, Integer id);

    @Query(value = "insert into favorite values(?1,?2)",nativeQuery = true)
    @Modifying
    void addFavorite(Integer userId, Integer id);

    @Query("select a from Article_  a,Favorite  f where f.uId=?1 and a.id=f.aId and a.title like ?2")
    Page<Article_> myFavoriteArticle(Integer loginUserId,String title, Pageable of);

}
