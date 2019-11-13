package com.shengxi.carblog.pojo;

import java.time.LocalDateTime;
import javax.persistence.*;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-13 23:41:31
 * 用户类
 */
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
    private LocalDateTime createTime;

    @Column(name = "content")
    private String content;

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

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createTime=" + createTime +
                ", content='" + content + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", status=" + status +
                '}';
    }
}
