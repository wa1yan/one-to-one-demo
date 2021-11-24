package com.example.demoonetoone.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String streetName;
    private String city;
    private String zipcode;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Customer customer;

    public Address() {
    }

    public Address(String streetName, String city, String zipcode) {
        this.streetName = streetName;
        this.city = city;
        this.zipcode = zipcode;
    }
}
