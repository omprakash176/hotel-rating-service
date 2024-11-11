package com.java8.features.chapter.eight;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer  = s -> System.out.println(s);
        consumer.accept("Hello");
        consumer.accept("Durga Software");
    }
}
