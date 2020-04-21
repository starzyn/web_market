/**
 * @ClassName LatexTest
 * @Description TODO
 * @Author Administrator
 * @Date 2020/4/10 16:34
 * @Version 1.0
 */
package com.qf.market.test;

public class LatexTest {
    public static void main(String[] args) {
        long a = (long)13.0000000000;
        int b = 5;
        double c = Math.ceil(a/(b*1.0));
        int d = (int)c;
        System.out.println("c=" + c + " d=" + d);
    }
}
