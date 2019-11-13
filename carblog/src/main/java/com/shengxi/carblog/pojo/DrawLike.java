package com.shengxi.carblog.pojo;

import javax.persistence.*;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-13 23:38:26
 * 相册点赞数
 */
@Entity
@Table(name = "draw_like")
public class DrawLike {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "draw_id")
    private Integer drawId;

    @Column(name = "user_id")
    private Integer userId;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDrawId() {
        return this.drawId;
    }

    public void setDrawId(Integer drawId) {
        this.drawId = drawId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DrawLike{" +
                "id=" + id +
                ", drawId=" + drawId +
                ", userId=" + userId +
                '}';
    }
}
