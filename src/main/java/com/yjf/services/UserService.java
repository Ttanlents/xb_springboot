package com.yjf.services;

import com.sun.org.apache.regexp.internal.RE;
import com.yjf.dao.UserDao;
import com.yjf.entity.Dept;
import com.yjf.entity.PageResult;
import com.yjf.entity.User;
import com.yjf.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/11/30 19:49
 * @Description
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserDao userDao;

    public  List<User> getUsers(Integer id) {
        return    userDao.findByDeptId(id);
    }


    public   User save(User user) {
        user.setRegisterTime(new Date());
        return userDao.save(user);
    }

    public User checkEmail(String email) {
     return userDao.findByEmail(email);
    }

    public User checkUsername(String username) {
      return userDao.findByUsername(username);
    }


    public   User resetPassword(User user){
        user.setRegisterTime(new Date());
        return userDao.save(user);
    }


    public User doLogin(String username, String password) {
      return  userDao.findByUsernameAndPassword(username,password);

    }

    public Page<User> selectPage(Integer pageCurrent, String username) {
     return userDao.findByUsernameLike("%"+username+"%",PageRequest.of(pageCurrent-1,PageResult.getPageSize()));
    }

    public User findById(Integer id) {
     return userDao.findById(id).get();
    }


    public List<Integer> findFocusById(Integer loginUserId) {
    return   userDao.findFocusById(loginUserId);
    }

    public User getUserDetail(Integer id) {
     return   userDao.findById(id).get();
    }

    public Integer getFocusCount(Integer id) {
     return userDao.countFocusById(id);
    }

    public Integer getFansCount(Integer id) {
      return userDao.countFansById(id);
    }

    public void updateUser(User one) {
      userDao.save(one);
    }



    @Transactional
    public void updateUserLookById(Integer id) {
      userDao.updateUserLookById(id);
    }


    public Boolean isFocusOtherById(Integer loginUserId,Integer id) {
    return userDao.countIsFocusById(loginUserId,id)>0?true:false;
    }

    @Transactional
    public void deleteFocus(Integer loginUserId, Integer id) {
      userDao.deleteFocus(loginUserId,id);
    }

    @Transactional
    public void insertFocus(Integer loginUserId, Integer id) {
      userDao.insertFocus(loginUserId,id);
    }


    public Page<User> getMyFocus(Integer loginUserId,Integer pageCurrent) {
     return userDao.findMyFocus(loginUserId,PageRequest.of(pageCurrent-1,PageResult.getPageSize()));
    }

    public void toChancelFocus(Integer loginUserId, Integer id) {
      userDao.deleteFocus(loginUserId,id);
    }
}
