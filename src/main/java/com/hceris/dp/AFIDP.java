package com.hceris.dp;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AFIDP {
    private AFIDP () {}

    public static List<String> breakWords(String input, Set<String> dict) {
        char[] chars = input.toCharArray();
        int[] prev = new int[chars.length];
        boolean[] endsHere = new boolean[chars.length];

        for(int i = 0; i < chars.length; i++) {
            for(int j = i; j >= 0; j--) {
                if(dict.contains(new String(chars, j, i - j + 1)) &&
                   (j == 0 || endsHere[j - 1])) {
                    endsHere[i] = true;
                    prev[i] = j - 1;
                    break;
                }
            }
        }

        LinkedList<String> result = new LinkedList<String>();
        if(endsHere[chars.length - 1]) {
            for(int end = chars.length - 1; end >= 0; end = prev[end]) {
                int start = prev[end] + 1;
                result.addFirst(new String(chars, start, end - start + 1));
            }
        }
        return result;
    }
        
}
