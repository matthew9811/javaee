package com.shengxi.carblog.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author: matthew
 * @ClassName TestUser
 * @Date: 2019-09-17 19:35
 * @Version: 1.0.0
 * @description:
 */
@Entity(name = "test_user")
@DynamicUpdate
@Data
@ToString
@EqualsAndHashCode
public class TestUser implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
}
