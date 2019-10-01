package com.shengxi.leung.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @Author: matthew
 * @ClassName Student
 * @Date: 2019-10-01 21:41
 * @Version: 1.0.0
 * @description:
 */
@Data
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private int sid;
    private String sname;
}
