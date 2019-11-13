package com.shengxi.carblog.pojo;

import javax.persistence.*;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-13 23:39:53
 * 管理员实体
 */
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "status")
    private char status;

    @Column(name = "make_up")
    private Integer makeUp;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public char getStatus() {
        return this.status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Integer getMakeUp() {
        return this.makeUp;
    }

    public void setMakeUp(Integer makeUp) {
        this.makeUp = makeUp;
    }
}
