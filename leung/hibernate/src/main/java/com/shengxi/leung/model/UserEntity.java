package com.shengxi.leung.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Set;

/**
 * @Author: matthew
 * @ClassName UserEntity
 * @Date: 2019-10-02 1:20
 * @Version: 1.0.0
 * @description:
 */
@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    private String name;

    private Set<SeatEntity> seats;

    public void addSeat(SeatEntity seatEntity) {
        seats.add(seatEntity);
    }
}
