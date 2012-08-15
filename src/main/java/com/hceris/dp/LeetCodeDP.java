package com.hceris.dp;

public class LeetCodeDP {
    private LeetCodeDP() {}

    public static int maximumSquareSubarray(int[][] m) {
        int[][] s = new int[m.length][m[0].length];

        for(int i = 0; i < m.length; i++) {
            s[i][0] = m[i][0];
        }

        for(int j = 0; j < m[0].length; j++) {
            s[0][j] = m[0][j];
        }

        int maxThusFar = 1;
        
        for(int i = 1; i < m.length; i++) {
            for(int j = 1; j < m[i].length; j++) {
                if(m[i][j] == 1) {
                    int size = Math.min(Math.min(s[i][j-1], s[i-1][j]), s[i-1][j-1]) + 1;
                    maxThusFar = Math.max(maxThusFar, size);
                    s[i][j] = size;
                } else {
                    s[i][j] = 0;
                }
            }
        }

        return maxThusFar;
    }
}
