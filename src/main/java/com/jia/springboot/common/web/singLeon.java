package com.jia.springboot.common.web;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jia on 2018/3/13.
 */
public class singLeon {
    private static singLeon ourInstance = new singLeon();

    public static singLeon getInstance() {
        return ourInstance;
    }

    private singLeon() {
        List<String> list= Arrays.asList("1");
    }

    public static void main(String[] args) {
        List<String> list= Arrays.asList("1");
        list.add("2");
        System.out.println(list);
    }
}
