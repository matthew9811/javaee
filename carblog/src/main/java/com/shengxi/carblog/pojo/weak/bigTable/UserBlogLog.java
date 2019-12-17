package com.shengxi.carblog.pojo.weak.bigTable;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 用户博客日志实体
 * @author yan
 * @date 2019-12-16 19:40:50
 * @version 1.0.0
 */
@Data
@Entity
@Table(name = "user")
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class UserBlogLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "blogCount")
    private Long blogCount;


}
