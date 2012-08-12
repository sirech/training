package com.hceris.strings;

public class AFIStrings {
    private AFIStrings() {}

    public static String rotateLeft(String s, int n) {
        char[] chars = s.toCharArray();

        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, n);
        reverse(chars, n + 1, chars.length - 1);

        return new String(chars);
    }

    public static String reverse(String s) {
    	char[] chars = s.toCharArray();
    	reverse(chars, 0, chars.length - 1);
    	return new String(chars);
    }
    
    public static void reverse(char[] s, int left, int right) {
        while(left < right) {
            swap(s, left++, right--);
        }
    }

    public static void swap(char[] s, int x, int y) {
        char tmp = s[x];
        s[x] = s[y];
        s[y] = tmp;
    }

    public static boolean isRotation(String s, String r) {
        return Matching.kmp(r + r, s) != -1;
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);

        int left = 0;
        while(true) {
            while(left < chars.length && Character.isWhitespace(chars[left])) {
                left++;
            }

            if(left == chars.length) {
                break;
            }

            int right = left + 1;
            while(right < chars.length && !Character.isWhitespace(chars[right])) {
                right++;
            }

            reverse(chars, left, right - 1);
            left = right;
        }

        return new String(chars);        
    }
}
