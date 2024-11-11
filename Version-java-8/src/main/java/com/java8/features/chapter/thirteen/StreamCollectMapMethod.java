package com.java8.features.chapter.thirteen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectMapMethod {
            public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("Pawan");
        list.add("Ravi Teja");
        list.add("Charan Jeevi");
        list.add("Venkath");
        list.add("Nagaurjun");
        System.out.println(list);

        List<String> list2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        // This is collect method called on filter                      .collect(Collectors.toList());
        System.out.println(list2);

        Long count = list.stream().filter(obj -> obj.length() > 3).count();
        System.out.println(count);
    }
}
