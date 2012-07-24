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
}
