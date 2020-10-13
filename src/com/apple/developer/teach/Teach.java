package com.apple.developer.teach;

import java.util.*;

public class Teach {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        //1
        hashMap.put("Tom", "CoreJava");
        hashMap.put("John", "Oracle");
        hashMap.put("Susan", "Oracle");
        hashMap.put("Jerry", "JDBC");
        hashMap.put("Jim", "unix");
        hashMap.put("Kevin", "JSP");
        //2
        hashMap.put("Lucy", "JSP");
        System.out.println(hashMap);
        System.out.println();
        //3
        hashMap.put("Allen", "JDBC");
        System.out.println(hashMap);
        System.out.println();
        //4
        hashMap.put("Lucy", "CoreJava");
        System.out.println(hashMap);
        System.out.println();
        //5
        Set set = hashMap.keySet();
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            System.out.println(key + "-->" + hashMap.get(key));
        }
        System.out.println("--------------------------");
        Set<Map.Entry<String, String>> set1 = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iter1 = set1.iterator();
        while (iter1.hasNext()) {
            Map.Entry<String, String> entry = iter1.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
}
