package com.java8.features.chapter.thirteen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    public static void main(String[] args) {

        List<List<String>> listOfList = new ArrayList<>();

        List<String> list1 = Arrays.asList("Omp","Prakash","Ramesh","Pawaan");
        List<String> list2 = Arrays.asList("Kamal","Praveena","Anup","Shanumgam");
        List<String> list3 = Arrays.asList("Anita","Rajshree","Ashwin","Debesh");

        listOfList.add(list1);
        listOfList.add(list2);
        listOfList.add(list3);

        System.out.println(listOfList);

        List<String> list4 = listOfList.stream()
                .flatMap(localList-> localList.stream()
                        .map(String :: toUpperCase))
                .collect(Collectors.toList());
        System.out.println(list4);

    }
}
