package com.yjf.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/11/20 10:39
 * @Description
 */
@Table(name = "dept")
@Entity
public class Dept implements Serializable {
    @Id
    private Integer id;

    private String  name;

    @Transient
    private List<User> userList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userList=" + userList +
                '}';
    }
}
