package com.java8.features.chapter.five;

public interface InterfaceLeft {

    default void m1() {
        System.out.println("Left Interface m1() Method  ");
    }
}
