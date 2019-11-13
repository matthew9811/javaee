package com.shengxi.carblog.pojo;

import javax.persistence.*;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-13 23:30:39
 * 博客类
 */
@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "blog_url")
    private String blogUrl;

    @Column(name = "status")
    private char status;

    @Column(name = "reviewer")
    private Integer reviewer;

    @Column(name = "remark")
    private String remark;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBlogUrl() {
        return this.blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public char getStatus() {
        return this.status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Integer getReviewer() {
        return this.reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", blogUrl='" + blogUrl + '\'' +
                ", status=" + status +
                ", reviewer=" + reviewer +
                ", remark='" + remark + '\'' +
                '}';
    }
}
