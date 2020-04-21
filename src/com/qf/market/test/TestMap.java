/**
 * @ClassName TestMap
 * @Description TODO
 * @Author Administrator
 * @Date 2020/4/9 9:10
 * @Version 1.0
 */
package com.qf.market.test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> hmap = new HashMap<>();
        hmap.put("111","aaa");
        if(hmap.get("222")!=null) {
            System.out.println("hahahha");
        }
    }
}
