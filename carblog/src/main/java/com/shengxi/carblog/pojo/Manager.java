package com.shengxi.carblog.pojo;

import lombok.ToString;

import javax.persistence.*;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-13 23:39:53
 * 管理员实体
 */
@Entity
@ToString
@Table(name = "manager")
public class Manager {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private char status;

    @Column(name = "make_up")
    private Integer makeUp;

    @JoinColumn(name = "user_id",table = "User", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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
