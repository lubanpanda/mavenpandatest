package com.panda;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        System.out.println(map.get("熊大"));
    }
}
