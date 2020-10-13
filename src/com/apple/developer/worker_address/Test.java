package com.apple.developer.worker_address;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new Worker("Tom", 22, 5000, new Address("Tokyo", "000")));
        set.add(new Worker("Tom", 22, 5000, new Address("Tokyo", "000")));
        set.add(new Worker("Tom", 22, 5000, new Address("Tokyo", "000")));
        set.add(new Worker("Tom", 22, 5000, new Address("Tokyo", "000")));
        set.add(new Worker("Tom", 22, 5000, new Address("Tokyo", "000")));
        System.out.println(set);
    }
}
