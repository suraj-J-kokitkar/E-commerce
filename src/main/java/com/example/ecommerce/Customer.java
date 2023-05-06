package com.example.ecommerce;

public class Customer {
    private int id;
    private String name, email, mobil;

    public Customer(int id, String name, String email, String mobil) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobil = mobil;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobil() {
        return mobil;
    }
}
