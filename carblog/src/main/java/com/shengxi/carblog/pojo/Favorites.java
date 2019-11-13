package com.shengxi.carblog.pojo;

import javax.persistence.*;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-13 23:39:03
 * 收藏
 */
@Entity
@Table(name = "favorites")
public class Favorites {
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

    @Override
    public String toString() {
        return "Favorites{" +
                "id=" + id +
                ", userId=" + userId +
                ", blogId='" + blogId + '\'' +
                '}';
    }
}
