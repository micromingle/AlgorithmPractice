package com.sneaker;

public class Util {

    public static void checkArgs(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("array can not be null");
        }
    }

    public static void d(String tag, String content) {
        System.out.print(tag + " : " + content);
    }

    public static void swap(int[] array, int m, int n) {
        int tem = array[m];
        array[m] = array[n];
        array[n] = tem;
    }
}
