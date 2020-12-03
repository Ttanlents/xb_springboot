package com.yjf.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 余俊锋
 * @date 2020/12/2 18:41
 * @Description
 */
@IdClass(Favorite.class)
@Entity
@Table(name ="favorite")
public class Favorite implements Serializable {

    @Id
    @Column(name = "u_id")
    private Integer uId;
    @Id
    @Column(name="a_id")
    private Integer aId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "favorite{" +
                "uId=" + uId +
                ", aId=" + aId +
                '}';
    }
}
