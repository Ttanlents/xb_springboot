package com.yjf.dao;

import com.yjf.entity.Dept;
import com.yjf.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/12/3 12:30
 * @Description
 */
public interface MeetDao extends JpaRepository<Meeting,Integer>, JpaSpecificationExecutor<Meeting> {


    @Query("select d from Dept d")
    List<Dept> getAllDept();

    @Query("select d from Dept d where d.id=?1 ")
    Dept findDeptById(Integer deptId);

    @Query("select count(1) from MeetingJoin mf where mf.mId=?1")
    int countByMeetId(Integer id);

    @Query("select count(1) from MeetingJoin mf where mf.uId=?1 and mf.mId=?2")
    Integer countMeetJoinByIds(Integer loginUserId, Integer id);

    @Query(value = "delete from meeting_join where u_id=?1 and m_id=?2",nativeQuery = true)
    @Modifying
    void deleteMeetJoin(Integer loginUserId, Integer id);

    @Query(value = "insert into meeting_join values(?1,?2)",nativeQuery = true)
    @Modifying
    void addMeetJoin(Integer loginUserId, Integer id);

    @Query("update Meeting m set m.status=?1 where m.id=?2")
    @Modifying
    void updateMeetStatus(Integer status,Integer id);

    List<Meeting> findByStatusNot(Integer status);
}
