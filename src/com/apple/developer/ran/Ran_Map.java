package com.apple.developer.ran;

import java.util.*;

public class Ran_Map {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        for(int i=0;i<1000;i++){
            list.add(new Random().nextInt(101));
        }
        System.out.println(list);
        Map<Integer, Integer> map=new HashMap<>();
        for(int i:list){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,map.get(i)+1);
            }
        }
        for(Map.Entry<Integer,Integer> en :map.entrySet()){
            System.out.println(en.getKey()+"--->"+en.getValue());
        }
    }
}
