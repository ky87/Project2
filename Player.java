package com.ex.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player", schema="public")
public class Player {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="email", nullable=false, unique=true)
    private String email;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name="rank")
    private int rank;

    @Column(name="location", nullable=false)
    private String location;

    public Player(){
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", rank=" + rank +
                ", location='" + location + '\'' +
                '}';
    }
}
