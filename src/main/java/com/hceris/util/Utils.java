package com.hceris.util;

public class Utils {
    private Utils() {}

    public static <T> void swap(T[] a, int x, int y) {
        T tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
    
    public static void swap(char[] a, int x, int y) {
        char tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
