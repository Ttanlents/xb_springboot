package com.yjf.dao;

import com.yjf.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 余俊锋
 * @date 2020/12/1 20:32
 * @Description
 */
@Repository
public interface DeptDao extends JpaRepository<Dept,Integer> {



}
