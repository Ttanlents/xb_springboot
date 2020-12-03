package com.yjf.services;

import com.yjf.dao.DeptDao;
import com.yjf.entity.Dept;
import com.yjf.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 余俊锋
 * @date 2020/12/1 20:35
 * @Description
 */
@Service
public class DeptService {
    @Autowired
    DeptDao deptDao;
    @Autowired
    DeptMapper deptMapper;


    public List<Dept> selectAllDept() {
      return   deptDao.findAll();
    }


    public  List<Dept>  findAllDept() {
        return   deptMapper.selectAllDept();
    }


    public Dept findById(Integer id){
        return deptDao.findById(id).get();
    }
}
