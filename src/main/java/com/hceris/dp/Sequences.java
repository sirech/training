package com.hceris.dp;

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
}
