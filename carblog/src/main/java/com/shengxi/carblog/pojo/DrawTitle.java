package com.shengxi.carblog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yan
 * @version 1.0.1
 * @date 2019-12-16 11:41:52
 * 相册
 */
@Data
@Entity
@Table(name = "draw_title")
@NoArgsConstructor
@AllArgsConstructor
public class DrawTitle {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 标题
     */
    @Column(name = "title")
    private String title;
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;
}
