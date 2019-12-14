package com.shengxi;


import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 *
 * @author yan
 * @date 2019-12-15 00:03:34
 */
@Data
@Entity(name = "User")
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private String password;
}
