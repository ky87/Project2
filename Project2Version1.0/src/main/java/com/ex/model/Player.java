package com.ex.model;



import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name="profile", schema="public")

public class Player {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable=false, unique=true)
    private String name;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="location", nullable=false)
    private String location;

    @Column(name="gender")
    private String gender;

    @Column(name="age", nullable=false)
    private int age;

    @Column(name="tennis_rank", nullable=false)
    private int tennis_rank;

    public Player(){
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTennis_rank() {
        return tennis_rank;
    }

    public void setTennis_rank(int tennis_rank) {
        this.tennis_rank = tennis_rank;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", tennis_rank=" + tennis_rank +
                '}';
    }
}
