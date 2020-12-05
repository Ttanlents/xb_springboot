package com.yjf.services;

import com.yjf.mapper.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 余俊锋
 * @date 2020/12/4 17:23
 * @Description
 */
@Service
public class HomeService {
    @Autowired
    private HomeMapper homeMapper;


    /**
     * 查询主页信息(今日新增用户、新增文章、新增会议数量)
     * @return
     */
    public Map<String,Long> findHomeCount(){
        return homeMapper.findHomeCount();
    }

    /**
     * 查询主页信息(近七日的数据详情)
     * @return
     */
    public List<Map<String, Long>> findHomeDetail(){
        return homeMapper.findHomeDetail();
    }
}

