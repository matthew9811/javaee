package com.shengxi.leung.entity;

import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private int age;
    private Date birthday;
    private float money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public User login() {

        return new User();
    }

    public void delete(int id) {
        System.out.println("delete");
    }

    public User get(int id) {
        return new User();
    }

    public List<User> listAll() {
        return null;
    }

    public List<User> listAllByName(String queryName) {
        return null;
    }

    public boolean register() {
        return false;
    }

    public void update() {
        System.out.println("update");
    }
}
