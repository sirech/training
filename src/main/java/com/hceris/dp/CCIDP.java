package com.hceris.dp;


public class CCIDP {
    private CCIDP() {}

    public static int countSteps(int n) {
        if(n == 0 || n == 1) { return 1; }
        if(n == 2) { return 2; }

        int p[] = new int[n+1];
        p[0] = 1;
        p[1] = 1;
        p[2] = 2;

        for(int i = 3; i <= n; i++) {
            p[i] = p[i-1] + p[i-2] + p[i-3];
        }
        return p[n];
    }

    public static int magicIndex(int[] a) {
        int left = 0;
        int right = a.length - 1;

        while(left <= right) {
            int middle = (left + right) >>> 1;

            if(a[middle] == middle) {
                return middle;
            } else if(a[middle] > middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static int magicIndexDupl(int[] a) {
    	return magicIndexDupl(a, 0, a.length - 1);
    }
    
    private static int magicIndexDupl(int[] a, int start, int end) {
    	if(start > end) {
    		return -1;
    	}
    	
        int middle = (start + end) >>> 1;

        if(a[middle] == middle) {
            return middle;
        }

        int left = magicIndexDupl(a, start, Math.min(middle - 1, a[middle]));
        if(left >= 0) {
            return left;
        }

        int right = magicIndexDupl(a, Math.max(middle + 1, a[middle]), end);
        return right;
    }    
}
