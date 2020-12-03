package com.yjf;

import com.yjf.dao.MeetDao;
import com.yjf.entity.Meeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class XbSpringbootApplicationTests {

  @Autowired
    MeetDao meetDao;

    @Test
   public void contextLoads() {
        List<Meeting> byStatusNot = meetDao.findByStatusNot(2);

        System.out.println(byStatusNot);
    }

}
