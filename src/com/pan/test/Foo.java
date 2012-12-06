package com.pan.test;

public class Foo {
    public static void main (String [] args) {
        StringBuffer a = new StringBuffer ("A");
        StringBuffer b = new StringBuffer ("B");
        operate (a,b);
        System.out.print(a + "," +b);
    }
    static void operate (StringBuffer x, StringBuffer y) {
    	System.out.println(x);
        x.append(y);
        System.out.println(x);
        System.out.println(y);
        y = x;
        System.out.println(y);
    }
}