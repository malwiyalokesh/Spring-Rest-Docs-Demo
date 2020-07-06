package com.sample.restdocsdemo.model;

import java.util.Objects;

public class User {

    private String name;
    private String email;

    public User() {

    }

    public User(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public User setName(final String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(final String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                   Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        return "User{" +
                   "name='" + name + '\'' +
                   ", email='" + email + '\'' +
                   '}';
    }

}
