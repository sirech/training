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

    public static List<Integer> knapsackZeroOne(int[] elements, int S) {
        boolean[][] partial = new boolean[elements.length + 1][S + 1];
        partial[0][0] = true;

        for(int i = 1; i <= elements.length; i++) {
            for(int j = 1; j <= S; j++) {
                if(partial[i - 1][j]) {
                    partial[i][j] = true;
                } else if(elements[i-1] <= j && partial[i-1][j - elements[i-1]]) {
                    partial[i][j] = true;
                    if(j == S) {
                        break;
                    }
                }
            }
        }

        LinkedList<Integer> result = new LinkedList<Integer>();
        int i = 0;
        int j = S;
        while(!partial[i][j]) {
            i++;
        }

        while(i > 0) {
            if(partial[i-1][j]) {
                i--;
            } else {
                result.addFirst(elements[i-1]);
                j -= elements[i-1];
                i--;
            }
        }
        
        return result;
    }
        
}
