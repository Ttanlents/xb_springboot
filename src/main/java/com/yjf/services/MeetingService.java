package com.yjf.services;

import com.yjf.dao.MeetDao;
import com.yjf.entity.Dept;
import com.yjf.entity.Meeting;
import com.yjf.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 余俊锋
 * @date 2020/12/3 12:06
 * @Description
 */
@Service
public class MeetingService {
    @Autowired
    MeetDao meetDao;
    public Page<Meeting> selectPage(Integer pageCurrent, Map searchMap) {
      return   meetDao.findAll(getSpec(searchMap), PageRequest.of(pageCurrent-1, PageResult.getPageSize(), Sort.by(Sort.Direction.DESC,"publishDate")));
    }

    public Specification<Meeting> getSpec(Map searchMap){
        return (Root<Meeting> root, CriteriaQuery<?> cq, CriteriaBuilder cb)->{
            List<Predicate> predicateList=new ArrayList<>();
            if (searchMap.get("title")!=null&&!searchMap.get("title").equals("")){
                Expression<String> title = root.get("title").as(String.class);
                Predicate predicate = cb.like(title, "%" + searchMap.get("title") + "%");
                predicateList.add(predicate);
            }
            if (searchMap.get("status")!=null&&!searchMap.get("status").equals("")){
                Expression<Integer> status = root.get("status").as(Integer.class);
                Predicate predicate = cb.equal(status, Integer.parseInt(searchMap.get("status")+""));
                predicateList.add(predicate);
            }
            Predicate[] arr=new Predicate[predicateList.size()];
            return cb.and(predicateList.toArray(arr));
        };
    }

    public List<Dept> getAllDept() {
        return  meetDao.getAllDept();
    }

    public Dept findDeptById(Integer deptId) {
        return meetDao.findDeptById(deptId);
    }

    public Meeting addMeet(Meeting meeting) {
        return meetDao.save(meeting);
    }

    public Meeting findById(Integer id) {
        return meetDao.getOne(id);
    }

    public int selectActuallyJoin(Integer id) {
       return meetDao.countByMeetId(id);
    }

    public Boolean findMeetingJoin(Integer loginUserId, Integer id) {
       return meetDao.countMeetJoinByIds(loginUserId,id)>0?true:false;
    }

    @Transactional
    public void deleteMeetJoin(Integer loginUserId, Integer id) {
        meetDao.deleteMeetJoin(loginUserId,id);
    }

    @Transactional
    public void addMeetJoin(Integer loginUserId, Integer id) {
        meetDao.addMeetJoin(loginUserId,id);
    }

    @Transactional
    public void updateMeetStatus(Integer status,Integer id) {
        meetDao.updateMeetStatus(status,id);
    }

    public  List<Meeting> findByStatusNot(Integer status){
        return meetDao.findByStatusNot(status);
    }
}
