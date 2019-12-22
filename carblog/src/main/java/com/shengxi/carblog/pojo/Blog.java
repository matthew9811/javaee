package com.shengxi.carblog.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
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
//
//    @Column(name = "user_id")
//    private Integer userId;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

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

    @Column(name = "create_time")
    private LocalDateTime createTime;


    public Blog() {
    }

    public Blog(String id, String title, LocalDateTime createTime) {
        this.id = id;
        this.title = title;
        this.createTime = createTime;
    }

    public Blog(User user, String blogUrl, String remark, String title, LocalDateTime createTime) {
        this.user = user;
        this.blogUrl = blogUrl;
        this.remark = remark;
        this.title = title;
        this.createTime = createTime;
    }

    public Blog(String blogUrl, String status, Integer reviewer,
                String remark, String title, LocalDateTime createTime) {
        this.blogUrl = blogUrl;
        this.status = status;
        this.reviewer = reviewer;
        this.remark = remark;
        this.title = title;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", blogUrl='" + blogUrl + '\'' +
                ", status=" + status +
                ", reviewer=" + reviewer +
                ", remark='" + remark + '\'' +
                '}';
    }
}
