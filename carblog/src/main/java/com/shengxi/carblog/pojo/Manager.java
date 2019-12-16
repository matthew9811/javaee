package com.shengxi.carblog.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-13 23:39:53
 * 管理员实体
 */
@Entity(name = "manager")
@ToString
@Table(name = "manager")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private char status;


    @OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "make_up", referencedColumnName = "id")
    private User makeUp;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
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

    public User getMakeUp() {
        return makeUp;
    }

    public void setMakeUp(User makeUp) {
        this.makeUp = makeUp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
