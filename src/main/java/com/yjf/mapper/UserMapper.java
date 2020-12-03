package com.yjf.mapper;

import com.yjf.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/11/17 20:07
 * @Description
 */
@Mapper
public interface UserMapper{
    @Select("select user.* from  favorite,user where favorite.u_id in (select userfocus.user_focus_id from userfocus where userfocus.user_id=#{loginUserId}) and favorite.a_id=#{articleId} and favorite.u_id=user.id")
    List<User> tooCollection(@Param("loginUserId") Integer loginUserId,@Param("articleId") Integer articleId);


    List<User> selectUsersByDeptId(Integer deptId);

}
