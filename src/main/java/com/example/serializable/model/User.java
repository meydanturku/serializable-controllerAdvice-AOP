package com.example.serializable.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    private transient String secret; // <-- Burası serialize edilmeyecek

    public User() {}

    public User(Long id, String name, String secret) {
        this.id = id;
        this.name = name;
        this.secret = secret;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSecret() { return secret; }
    public void setSecret(String secret) { this.secret = secret; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', secret='" + secret + "'}";
    }
}
