package com.yjf.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 余俊锋
 * @date 2020/12/4 17:26
 * @Description
 */
@Mapper
public interface HomeMapper {
    Map<String, Long> findHomeCount();

    List<Map<String, Long>> findHomeDetail();
}
