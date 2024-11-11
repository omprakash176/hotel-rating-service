package com.java8.features.chapter.fourteen;

import java.util.Optional;

public class Employee {

    private String name;
    private Optional<String> email;

    public Employee(String name, Optional<String> email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }
}
