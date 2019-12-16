package com.shengxi.carblog.pojo;

import javax.persistence.*;

/**
 * @author yan
 * @version 1.1.0
 * @date 2019-11-13 23:33:40
 * 照片类
 */
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

    @Column(name = "content_url")
    private String contentUrl;

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

    public String getContentUrl() {
        return this.contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public Integer getReviewer() {
        return this.reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Draw{" +
                "id=" + id +
                ", userId=" + userId +
                ", status=" + status +
                ", contentUrl='" + contentUrl + '\'' +
                ", reviewer=" + reviewer +
                '}';
    }
}
