package com.shengxi.carblog.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-13 23:30:39
 * 博客类
 */
@Entity
@Getter
@Setter
@Table(name = "blog")
@AllArgsConstructor
public class Blog implements Serializable {
    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "blog_url")
    private String blogUrl;

    @Column(name = "status")
    private String status;

    @Column(name = "reviewer")
    private Integer reviewer;

    @Column(name = "remark")
    private String remark;
    @Column(name = "title")
    private String title;

    public Blog() {
    }

    public Blog(Integer userId, String blogUrl, String status, Integer reviewer, String remark, String title) {
        this.userId = userId;
        this.blogUrl = blogUrl;
        this.status = status;
        this.reviewer = reviewer;
        this.remark = remark;
        this.title = title;
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
