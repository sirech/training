package com.hceris.strings;

import java.util.Arrays;

public class LeetCodeStrings {
    private LeetCodeStrings() {}

    // Only positive numbers
    public static String multiply(String a, String b) {
        String result = "0";
        String carry = "";

        for(int i = b.length() - 1; i >= 0; i--) {
        	String mul = multiply(a, b.charAt(i)) + carry;
            result = sum(result, mul);
            carry += "0";
        }

        return result;
    }

    // Only positive numbers
    private static String multiply(String a, char b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        for(int i = a.length() - 1; i >= 0; i--) {
            int sum = (toInt(a.charAt(i)) * toInt(b)) + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        while(carry > 0) {
            result.append(carry % 10);
            carry /= 10;
        }

        return result.reverse().toString();
    }

    // Only positive numbers
    public static String sum(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while(i >= 0 || j >= 0 || carry > 0) {
            int digit_a = i < 0 ? 0 : toInt(a.charAt(i));
            int digit_b = j < 0 ? 0 : toInt(b.charAt(j));
            int sum = digit_a + digit_b + carry;
            result.append(sum % 10);
            
            carry = sum / 10;
            i--;
            j--;
        }

        return result.reverse().toString();
    }

    private static int toInt(char c) {
        return c - '0';
    }

    public static String nextPermutation(String s) {
        char[] chars = s.toCharArray();
        int k = chars.length - 2;

        while(k >= 0 && chars[k] >= chars[k+1]) {
            k--;
        }

        if(k == -1) {
            Arrays.sort(chars);
            return new String(chars);
        }

        int l = chars.length - 1;
        while(l > 0 && chars[l] <= chars[k]) {
            l--;
        }

        swap(chars, k, l);
        AFIStrings.reverse(chars, k+1, chars.length - 1);
        return new String(chars);
    }

    private static void swap(char[] a, int x, int y) {
        char tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
