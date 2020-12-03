package com.yjf.controller;

import com.yjf.entity.Dept;
import com.yjf.entity.Result;
import com.yjf.services.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/12/3 18:04
 * @Description
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;


    @PostMapping(value = "/getDeptDetail")
    @ResponseBody
    public Result getDeptDetail() {
       List<Dept> deptList=deptService.findAllDept();
        return new Result(true, "查询成功",deptList);
    }
}
