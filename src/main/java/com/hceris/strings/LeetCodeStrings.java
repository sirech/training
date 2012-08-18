package com.hceris.strings;

import static com.hceris.util.Utils.swap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public static boolean isScramble(String s1, String s2) {
        Map<String, Boolean> hm = new HashMap<String, Boolean>();
        return isScramble(s1, s2, hm);
    }

    private static boolean isScramble(String s1, String s2, Map<String,Boolean> hm) {
        if (s1 == null || s2 == null)
            return false;

        if (s1.length() != s2.length())
            return false;

        if (s1.equals(s2))
            return true;

        String key1 = s1 + ":" + s2;
        String key2 = s2 + ":" + s1;

        if (hm.containsKey(key1))
            return hm.get(key1);

        if (hm.containsKey(key2))
            return hm.get(key2);

        int n = s1.length();
        boolean ret = false;
        for (int i = 1; i < n; i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0, i), hm)
               && isScramble(s1.substring(i, n), s2.substring(i, n), hm)) {
                ret = true;
                break;
            }


            if (isScramble(s1.substring(0, i), s2.substring(n - i, n), hm)
                && isScramble(s1.substring(i, n), s2.substring(0, n - i), hm)) {
                ret = true;
                break;
            }
        }

        hm.put(key1, ret);
        return ret;
    }
}
