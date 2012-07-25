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
}
