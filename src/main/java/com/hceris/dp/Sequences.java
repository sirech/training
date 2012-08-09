package com.hceris.dp;

import com.hceris.strings.AFIStrings;

public class Sequences {
    private Sequences() {}

    public static int[] longestIncreasingRun(int[] a) {
        int longestRun = 1;
        int last = 0;
        int currentRun = 1;

        for(int i = 1; i < a.length; i++) {
            if(a[i-1] < a[i]) {
                currentRun++;
                if(currentRun > longestRun) {
                    longestRun = currentRun;
                    last = i;
                }
            } else {
            	    	currentRun = 1;
            }
        }

        int[] run = new int[longestRun];
        for(int i = longestRun - 1; i >= 0; i--) {
            run[i] = a[last - longestRun + 1 + i];
        }
        return run;
    }

    public static int[] longestIncreasingSequence(int[] a) {
        int[] seq = new int[a.length];
        int[] prev = new int[a.length];
        int max = 0;

        for(int i = 0; i < a.length; i++) {
            seq[i] = 1;
            prev[i] = -1;

            for(int j = 0; j < i; j++) {
                if(a[j] < a[i] && seq[j] + 1 > seq[i]) {
                    seq[i] = seq[j] + 1;
                    prev[i] = j;
                }
            }

            if(seq[i] > seq[max]) {
                max = i;
            }
        }

        int[] res = new int[seq[max]];
        for(int i = seq[max] - 1, k = max; k != -1; i--, k = prev[k]) {
            res[i] = a[k];
        }
        return res;
    }

    public static int[] maximumSubArray(int[] a) {
        int start = -1;
        int end = -2;
        int max = 0;
        int maxhere = 0;

        for(int i = 0; i < a.length; i++) {
            int newmaxhere = Math.max(0, maxhere + a[i]);
            if(newmaxhere > max) {
                max = newmaxhere;
                end = i;
                if(maxhere == 0) {
                    start = i;
                }
            }
            maxhere = newmaxhere;
        }

        int[] res = new int[end - start + 1];
        for(int i = 0; i < res.length; i++) {
            res[i] = a[i + start];
        }

        return res;
    }

    public static int cutRod(int[] p, int n) {
        int[] partial = new int[n + 1];
        int[] cuts = new int[n + 1];
        partial[0] = 0;

        for(int i = 1; i <= n; i++) {
            int q = -1;
            for(int j = 1; j <= i; j++) {
                if( q < p[j] + partial[i - j]) {
                    q = p[j] + partial[i - j];
                    cuts[i] = j;
                }
            }
            partial[i] = q;
        }

        return partial[n];
    }

    public static String longestCommonSubsequence(String a, String b) {
        return new String(longestCommonSubsequence(a.toCharArray(), b.toCharArray()));
    }

    public static char[] longestCommonSubsequence(char[] a, char[] b) {
        int[][] m = new int[a.length + 1][b.length + 1];

        for(int i = 1; i <= a.length; i++) {
            for(int j = 1; j <= b.length; j++) {
                if(a[i-1] == b[j-1]) {
                    m[i][j] = m[i-1][j-1] + 1;
                } else {
                    m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
                }
            }
        }

        char[] res = new char[m[a.length][b.length]];
        for(int k = res.length - 1, i = a.length, j = b.length; i > 0 && j > 0; ){
            if(a[i - 1] == b[j - 1]) {
                res[k] = a[i - 1];
                k--; i--; j--;
            } else if (m[i][j - 1] > m[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }

        return res;
    }
    
    public static String longestPalindrome(String s) {
    	return longestCommonSubsequence(s, new String(AFIStrings.reverse(s)));
    }

    public static int minDistance(Iterable<String> words, String w1, String w2) {
        int distance = Integer.MAX_VALUE;
        int counter = 0;
        String lastWord = "";

        for(String word : words) {
            if(word.equals(w1) || word.equals(w2)) {
                if(!lastWord.isEmpty() && !lastWord.equals(word)) {
                    distance = Math.min(distance, counter);
                }
                
                lastWord = word;
                counter = 0;
            } else {
                counter++;
            }
        }

        return distance;
    }
    
    public static int editDistance(String a, String b) {
        return editDistance(a.toCharArray(), b.toCharArray());
    }

    public static int editDistance(char[] a, char[] b) {
        int[][] m = new int[a.length + 1][b.length + 1];
        
        for(int i = 0; i < a.length + 1; i++) {
        	m[i][0] = i;
        }
        
        for(int j = 0; j < b.length + 1; j++) {
        	m[0][j] = j;
        }

        for(int i = 1; i <= a.length; i++) {
            for(int j = 1; j <= b.length; j++) {
                if(a[i-1] == b[j-1]) {
                    m[i][j] = m[i-1][j-1];
                } else {
                    m[i][j] = Math.min(m[i-1][j], Math.min(m[i][j-1], m[i-1][j-1])) + 1;
                }
            }
        }
        
        return m[a.length][b.length];
    }
}
