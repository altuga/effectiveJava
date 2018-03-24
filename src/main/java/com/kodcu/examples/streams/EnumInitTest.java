package com.kodcu.examples.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class EnumInitTest {
    public static void main(String[] args) {
        System.out.println("start...");
        System.out.println(Fruit.BANANA);
        System.out.println("end.");
    }
}


enum Fruit {
   APPLE, BANANA, UNKNOWN;
   private static final Map<String, Fruit> FRUITS_BY_NAME =
           new ConcurrentHashMap<>();
   static {
       Arrays.stream(Fruit.values()).forEach(t -> {
           FRUITS_BY_NAME.put(t.name(), t);
       });
   }
}