package com.java8.features.chapter.eight;

public class Student {
    String name;
    Integer marks;


    public Student(String name, Integer marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
