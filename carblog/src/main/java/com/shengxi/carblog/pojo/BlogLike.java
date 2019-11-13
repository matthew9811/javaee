package com.shengxi.carblog.pojo;

import javax.persistence.*;

@Entity
@Table(name = "blog_like")
public class BlogLike {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "blog_id")
    private String blogId;


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

    public String getBlogId() {
        return this.blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
}
