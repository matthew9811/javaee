package com.shengxi.carblog.pojo;

import javax.persistence.*;

@Entity
@Table(name = "draw")
public class Draw {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "status")
    private char status;

    @Column(name = "concent_url")
    private String concentUrl;

    @Column(name = "reviewer")
    private Integer reviewer;


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

    public char getStatus() {
        return this.status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getConcentUrl() {
        return this.concentUrl;
    }

    public void setConcentUrl(String concentUrl) {
        this.concentUrl = concentUrl;
    }

    public Integer getReviewer() {
        return this.reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }
}
