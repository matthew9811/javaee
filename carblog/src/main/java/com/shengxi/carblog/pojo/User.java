package com.shengxi.carblog.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;


/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-13 23:41:31
 * 用户类实体
 */
@Entity(name = "User")
@Table(name = "user")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String status;

    public User(String name, String pwd, LocalDateTime createTime) {
        this.name = name;
        this.pwd = pwd;
        this.createTime = createTime;
    }

    public User(Integer id) {
        this.id = id;
    }

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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
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
