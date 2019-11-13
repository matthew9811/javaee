package com.shengxi.carblog.pojo;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "create_time")
    private java.sql.Timestamp createTime;

    @Column(name = "concent")
    private String concent;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "status")
    private char status;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public java.sql.Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getConcent() {
        return this.concent;
    }

    public void setConcent(String concent) {
        this.concent = concent;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public char getStatus() {
        return this.status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
