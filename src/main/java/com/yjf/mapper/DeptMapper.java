package com.yjf.mapper;

import com.yjf.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/12/3 18:12
 * @Description
 */
@Mapper
public interface DeptMapper {

    List<Dept> selectAllDept();
}
