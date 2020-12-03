package com.yjf.dao;

import com.yjf.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/11/30 19:42
 * @Description
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {

     List<User> findByDeptId(Integer id);


    User findByUsername(String username);

    User findByEmail(String email);

    User findByUsernameAndPassword(String username, String password);

    Page<User> findByUsernameLike(String pageCurrent, Pageable of);

    @Query("select uf.userFocusId  from UserFocus uf where uf.userId=?1")
    List<Integer> findFocusById(Integer loginUserId);

    @Query("select count(1) from UserFocus uf where uf.userId=?1")
    Integer countFocusById(Integer id);

    @Query("select count(1) from UserFocus uf where uf.userFocusId=?1")
    Integer countFansById(Integer id);

    @Query("update User u set u.look=u.look+1 where u.id=?1")
    @Modifying
    void updateUserLookById(Integer id);


    @Query("select count(1) from UserFocus uf where uf.userId=?1 and uf.userFocusId=?2")
    Integer countIsFocusById(Integer loginUserId,Integer id);

    @Query("delete from UserFocus uf where  uf.userId=?1 and uf.userFocusId=?2")
    @Modifying
    void deleteFocus(Integer loginUserId, Integer id);

    @Query(value = "insert into userFocus values(?1,?2)",nativeQuery = true)
    @Modifying
    void insertFocus(Integer loginUserId, Integer id);

    @Query("select u from UserFocus uf,User u where uf.userId=?1 and uf.userFocusId=u.id")
   Page<User> findMyFocus(Integer id,Pageable of);
}
