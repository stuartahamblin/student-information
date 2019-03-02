package com.example.education.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StudentService {


    public static void main(String[] args) {
        Set<Integer> mySet = new HashSet<>();
        mySet.add(5);
        mySet.add(7);
        mySet.add(-4);
        mySet.add(2);
        mySet.add(5);
        System.out.format("Set: %s%n", mySet);

        int i = new ArrayList<>(mySet).indexOf(2);
        System.out.format("index of 2: %d%n", i);
    }
}

