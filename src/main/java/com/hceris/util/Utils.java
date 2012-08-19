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
    
    public static int max(int[] a) {
    	int max = a[0];
    	for(int i = 1; i < a.length; i++) {
    		max = Math.max(max, a[i]);
    	}
    	return max;
    }
    
    public static int min(int[] a) {
    	int min = a[0];
    	for(int i = 1; i < a.length; i++) {
    		min = Math.min(min, a[i]);
    	}
    	return min;
    }
}
