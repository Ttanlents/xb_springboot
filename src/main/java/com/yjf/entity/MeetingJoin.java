package com.yjf.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 余俊锋
 * @date 2020/12/3 16:07
 * @Description
 */
@Table(name="meeting_join")
@Entity
@IdClass(MeetingJoin.class)
public class MeetingJoin implements Serializable {
    @Id
    @Column(name = "u_id")
    private Integer uId;
    @Id
    @Column(name = "m_id")
    private Integer mId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    @Override
    public String toString() {
        return "MeetingJoin{" +
                "uId=" + uId +
                ", mId=" + mId +
                '}';
    }
}
