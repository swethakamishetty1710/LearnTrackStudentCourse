package com.airtribe.learntrack.entity;

import java.util.regex.Pattern;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private int id;
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public Person(String firstName, String lastName, String email, int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        setEmail(email);
        this.id = id;
    }

    public void setEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String getDisplayName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
