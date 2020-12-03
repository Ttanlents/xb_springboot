package com.yjf.controller;

import com.yjf.entity.*;
import com.yjf.services.MeetingService;
import com.yjf.services.UserService;
import com.yjf.utils.JsonUtils;
import com.yjf.utils.LoginUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author 余俊锋
 * @date 2020/12/3 12:03
 * @Description
 */
@RestController
@RequestMapping("meet")
public class MeetingController {
    @Autowired
    MeetingService meetingService;

    @Autowired
    UserService userService;


    @PostMapping(value = "/selectPage/{pageCurrent}")
    @ResponseBody
    public Result selectPage(@PathVariable Integer pageCurrent, @RequestBody Map searchMap) {

        Page<Meeting> page = meetingService.selectPage(pageCurrent, searchMap);
        PageResult<Meeting> obj = new PageResult<>(page.getTotalPages() == 0 ? 1 : page.getTotalPages(), page.getContent());
        return new Result(true, "查询成功", obj);
    }


    @GetMapping(value = "/getAllDept")
    @ResponseBody
    public Result getAllDept() {

        List<Dept> depts = meetingService.getAllDept();

        return new Result(true, "查询成功", depts);
    }

    @GetMapping(value = "/getUsers/{id}")
    @ResponseBody
    public Result getUsers(@PathVariable Integer id) {
        List<User> userList = userService.getUsers(id);

        return new Result(true, "查询成功", userList);
    }


    /**
     * @return com.yjf.entity.Result
     * @Description TODO:发布会议
     * @author 余俊锋
     * @date 2020/11/21 11:29
     * @params map
     */
    @RequestMapping(value = "doSave", method = RequestMethod.POST)
    @ResponseBody
    public Result doSave(@RequestBody Map<String, Object> map) {
        Object obj = map.get("meet");
        String json = JsonUtils.pojoToJson(obj);
        Meeting meeting = JsonUtils.jsonToPojo(json, Meeting.class);
        String makeUsers = (String) map.get("makeUser");
        meeting.setPublishDate(new Date());
        meeting.setMakeUser(makeUsers);
        meeting.setStatus(0);
        Dept dept = meetingService.findDeptById(meeting.getDeptId());
        meeting.setDeptName(dept.getName());
        meetingService.addMeet(meeting);
        return new Result(true, "发布成功", null);
    }
     /**
      *isJoinMeeting   true参加过了  false没参加过
     * @param id
     */
    @GetMapping(value = "getDetail/{id}")
    @ResponseBody
    public Result doSave(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        Meeting meeting = meetingService.findById(id);
        int makeUserCount = 0;
        Integer loginId = LoginUserUtils.getLoginUserId();
        Boolean isJoinMeeting = meetingService.findMeetingJoin(loginId,id); //true参加过了  false没参加过
        String makeUser = meeting.getMakeUser();
        if (makeUser != null && !makeUser.equals("")) {
            String[] split = makeUser.split(",");
            makeUserCount = split.length; //应到
        }
        int joinCount = meetingService.selectActuallyJoin(id);       //实到
        int noJoinCount = makeUserCount - joinCount;      //未到
        map.put("meeting", meeting);
        map.put("makeUserCount", makeUserCount);
        map.put("joinCount", joinCount);
        map.put("noJoinCount", noJoinCount);
        map.put("isJoinMeeting", isJoinMeeting);
        return new Result(true, "发布成功", map);
    }


    /**
     * flag    true 参加过了
     * false 不没参加过
     * isNeedJoin    true需要参加  false不需要参加
     *
     * @param id
     */
    @RequestMapping(value = "/joinMeeting/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result joinMeeting(@PathVariable Integer id) {
        Integer loginUserId = LoginUserUtils.getLoginUserId();
        Meeting meeting = meetingService.findById(id);
        Boolean flag = meetingService.findMeetingJoin(loginUserId, id);
        String makeUser = meeting.getMakeUser();
        List<String> list = Arrays.asList(makeUser.split(","));
        Boolean isNeedJoin=list.contains(loginUserId+"");

        if (isNeedJoin) {
            if (meeting.getStatus() == 1) {
                return new Result(false, "会议已经开始", null);
            }
            if (meeting.getStatus() == 2) {
                return new Result(false, "会议已经结束", null);
            }
            if (meeting.getStatus() == 0) {
                if (flag){
                    //参加过了
                    meetingService.deleteMeetJoin(loginUserId,id);
                    return new Result(true, "取消参加成功", 400);
                }else {
                    //还没参加
                    meetingService.addMeetJoin(loginUserId,id);
                    return new Result(true, "参加会议成功", 200);
                }
            }
        }
        return new Result(false, "你不能操作该会议", null);

    }


}
