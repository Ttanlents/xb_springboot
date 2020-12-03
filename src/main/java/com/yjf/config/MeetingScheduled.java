package com.yjf.config;

import com.yjf.entity.Meeting;
import com.yjf.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/12/3 19:07
 * @Description
 */
@Component

public class MeetingScheduled {
   @Autowired
    MeetingService meetingService;

    @Scheduled(cron = "10 * * * * ?")
   public void doUpdate(){
       List<Meeting> meetingList = meetingService.findByStatusNot(2);
       for (Meeting meeting : meetingList) {
           long startTime = meeting.getStartTime().getTime();
           long endTime = meeting.getEndTime().getTime();
           long now=System.currentTimeMillis();
           if (now>startTime&&meeting.getStatus()==0){
               System.out.println("修改中");
               meetingService.updateMeetStatus(1,meeting.getId());
           }
           if (now>endTime&&meeting.getStatus()==1){
               System.out.println("修改2");
               meetingService.updateMeetStatus(2,meeting.getId());
           }
       }
   }

}
