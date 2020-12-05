package com.yjf.controller;


import com.yjf.entity.Result;
import com.yjf.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 余俊锋
 * @date 2020/12/4 17:22
 * @Description
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    /**
     * 查询首页数据(新增用户、新增文章、新增会议）
     *
     * @return
     */
    @GetMapping
    public Result home() {
        // 查询当日新增信息
        Map<String, Long> countData = homeService.findHomeCount();

        // 查询近七日的数据详情
        List<Map<String, Long>> detailData = homeService.findHomeDetail();

        /**
         * 把map数据类型转换为集合数据类型方便前端填充数据
         * Map:day1:0 day1:3 day2:1 day3:2 day4:3 day5:1 day6:1
         * List: [0,3,1,2,3,1,1]
         */
        List<List<Long>> countList = new ArrayList<>();
        for (Map<String, Long> map : detailData) {

            List<Long> temp = new ArrayList();

            for (Map.Entry<String, Long> entry : map.entrySet()) {
                Long val = map.get(entry.getKey());
                temp.add(val);
            }
            countList.add(temp);
        }

        Map<String, Object> returnMap = new HashMap<>();

        // count数据
        returnMap.put("countData", countData);

        // 报表详细数据
        returnMap.put("detailData", countList);

        return new Result(true, "查询成功", returnMap);
    }
}