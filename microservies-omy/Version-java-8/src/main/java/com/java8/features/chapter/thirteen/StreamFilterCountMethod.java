package com.java8.features.chapter.thirteen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterCountMethod {

    public static void main(String[] args) {
        {
            List<String> list = new ArrayList<String>();
            list.add("Pawan");
            list.add("Ravi Teja");
            list.add("Charan Jeevi");
            list.add("Venkath");
            list.add("Nagaurjun");
            list.add("Ravi");
            list.add("Karan");
            System.out.println(list);

            Long count = list.stream().filter(obj-> obj.length()> 5).count();
            System.out.println(count);
        }
    }

}
