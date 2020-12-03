package com.yjf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 余俊锋
 * @date 2020/12/1 15:23
 * @Description
 */
@Entity
@Table(name = "userfocus")
public class UserFocus implements Serializable {

    @Id
    @Column(name="user_id")
    private Integer userId;

    @Id
    @Column(name="user_focus_id")
    private Integer userFocusId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserFocusId() {
        return userFocusId;
    }

    public void setUserFocusId(Integer userFocusId) {
        this.userFocusId = userFocusId;
    }

    @Override
    public String toString() {
        return "UserFocus{" +
                "userId=" + userId +
                ", userFocusId=" + userFocusId +
                '}';
    }
}
