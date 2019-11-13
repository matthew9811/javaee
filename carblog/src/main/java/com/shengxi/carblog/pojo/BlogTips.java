package com.shengxi.carblog.pojo;

import javax.persistence.*;

@Entity
@Table(name = "blog_tips")
public class BlogTips {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "blog_id")
    private String blogId;

    @Column(name = "order")
    private Integer order;

    @Column(name = "tip_id")
    private Integer tipId;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogId() {
        return this.blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public Integer getOrder() {
        return this.order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getTipId() {
        return this.tipId;
    }

    public void setTipId(Integer tipId) {
        this.tipId = tipId;
    }
}
