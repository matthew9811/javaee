package com.shengxi.leung.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * @Author: matthew
 * @ClassName SeatEntity
 * @Date: 2019-10-02 1:20
 * @Version: 1.0.0
 * @description:
 */
@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SeatEntity {
    private String id;
    private String place;
    private String userId;
}
