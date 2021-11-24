package com.example.demoonetoone.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_name")
    private String name;
    private String hobby;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    private Address address;

    public Customer() {
    }

    public Customer(String name, String hobby) {
        this.name = name;
        this.hobby = hobby;
    }
}
