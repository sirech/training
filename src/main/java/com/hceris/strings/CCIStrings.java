package com.hceris.strings;

import java.util.Arrays;

import com.google.common.base.Preconditions;

public class CCIStrings {
    private CCIStrings() {}

    // Assumptions: chars ascii
    public static boolean uniqueASCIIChars(String s) {
        Preconditions.checkNotNull(s);

        if(s.length() > 256) { return false; }

        boolean[] seen = new boolean[256];
        for(int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if(seen[val]) {
                return false;
            }

            seen[val] = true;
        }

        return true;
    }

    // Assumptions: case sensitive, whitespace is relevant
    public static boolean isPermutation(String s, String perm) {
        if(s.length() != perm.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        Arrays.sort(sChars, 0, sChars.length - 1);

        char[] sPerm = perm.toCharArray();
        Arrays.sort(sPerm, 0, sPerm.length - 1);

        return Arrays.equals(sChars, sPerm);
    }

    // Assumptions: s is exactly big enough to contain the expanded
    // string, all the whitespace between two words is replaced by one
    // expanded whitespace
    // WARNING: might be incorrect
    public static String replaceWhitespace(String s, int realLength) {
        char[] sChars = s.toCharArray();
        int current = realLength - 1;
        int newPointer = sChars.length - 1;

        while(current >= 0) {
            int whitespace = current - 1;
            while(whitespace >= 0 && !Character.isWhitespace(sChars[whitespace])) {
                whitespace--;
            }

            newPointer = move(sChars, current, newPointer, current - whitespace);

            while(whitespace >= 0 && Character.isWhitespace(sChars[whitespace])) {
                whitespace--;
            }
            
            newPointer = putWhitespace(sChars, newPointer);
            current = whitespace;
        }

        return new String(sChars);
    }

    private static int move(char[] s, int srcEnd, int dstEnd, int length) {
        for(int i = 0; i < length; i++) {
            s[dstEnd--] = s[srcEnd--];
        }
        return dstEnd;
    }

    private static int putWhitespace(char[] s, int end) {
        if(end < 0) { return end; }

        s[end] = '0';
        s[end-1] = '2';
        s[end-2] = '%';
        
        return end - 3;
    }

    public static String compress(String s) {
        StringBuilder builder = new StringBuilder();
        int i = 0;

        while(i < s.length()) {
            char candidate = s.charAt(i);
            int end = i + 1;

            while(end < s.length() && candidate == s.charAt(end)) {
                end++;
            }

            builder.append(candidate);
            int repetitions = end - i;

            if(repetitions > 1) {
                builder.append(repetitions);
            }
            
            i = end;
        }

        return builder.toString();
    }
}
