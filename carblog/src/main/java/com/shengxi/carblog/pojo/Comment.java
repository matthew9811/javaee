package com.shengxi.carblog.pojo;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "concent")
    private String concent;

    @Column(name = "create_time")
    private java.sql.Timestamp createTime;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "blog_id")
    private String blogId;

    @Column(name = "blog_user_id")
    private Integer blogUserId;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConcent() {
        return this.concent;
    }

    public void setConcent(String concent) {
        this.concent = concent;
    }

    public java.sql.Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBlogId() {
        return this.blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public Integer getBlogUserId() {
        return this.blogUserId;
    }

    public void setBlogUserId(Integer blogUserId) {
        this.blogUserId = blogUserId;
    }
}
