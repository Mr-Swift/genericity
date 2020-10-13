package com.apple.developer.ran;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ran {
    public static void main(String[] args) {
        Random random = new Random();
        List list = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(101));
        }
        System.out.println(list);
        for (int i = 0; i < 101; i++) {
            int count = 0;
            for (Object obj : list) {
                int n = (int) obj;
                if (n == i) {
                    count++;
                }
            }
            if (count != 0) {
                System.out.println(i + "--->出现" + count + "次");
            }
        }
    }
}
