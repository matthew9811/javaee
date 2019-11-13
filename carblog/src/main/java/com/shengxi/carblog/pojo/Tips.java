package com.shengxi.carblog.pojo;

import javax.persistence.*;

@Entity
@Table(name = "tips")
public class Tips {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
