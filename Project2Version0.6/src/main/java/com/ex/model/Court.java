package com.ex.model;


import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name="courts", schema ="public")

public class Court {
    @Id
    @Column(name="id")
    private int id;

    @Column (name="address", nullable = false, unique = true)
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Court{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
