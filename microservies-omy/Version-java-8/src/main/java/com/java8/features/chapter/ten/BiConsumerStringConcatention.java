package com.java8.features.chapter.ten;

import java.util.function.BiConsumer;

public class BiConsumerStringConcatention {
    public static void main(String[] args) {


        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a + b);
        biConsumer.accept("Omprakash ", "Panwar");
    }
}
