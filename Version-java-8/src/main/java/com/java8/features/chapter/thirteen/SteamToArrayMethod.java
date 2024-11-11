package com.java8.features.chapter.thirteen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SteamToArrayMethod {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(100);
        list.add(99);
        list.add(98);
        list.add(85);
        list.add(67);
        list.add(70);
        System.out.println(list);

        Integer[] arr = list.stream().toArray(Integer[]::new);
        System.out.println(arr);

        }
    }
