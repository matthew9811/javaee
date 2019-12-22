package com.shengxi.carblog.pojo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yan
 * @date 2019-11-13 23:32:41
 * 博客评论
 */
@Getter
@Setter
@Entity
@ToString
@Table(name = "comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "blog_id")
    private String blogId;

    @Column(name = "blog_user_id")
    private Integer blogUserId;
}
