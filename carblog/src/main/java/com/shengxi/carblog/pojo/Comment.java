package com.shengxi.carblog.pojo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author yan
 * @date 2019-11-13 23:32:41
 * 博客评论
 */
@Entity
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "concent")
    private String concent;

    @Column(name = "create_time")
    private LocalDateTime createTime;

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

    public LocalDateTime getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", concent='" + concent + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", blogId='" + blogId + '\'' +
                ", blogUserId=" + blogUserId +
                '}';
    }
}
