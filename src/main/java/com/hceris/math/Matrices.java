package com.hceris.math;

public class Matrices {
    private Matrices() {}

    public static <T> void rotateNinetyDegreesRight(T[][] m) {
        int n = m.length;

        for(int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for(int i = first; i < last; i++) {
                int offset = i - first;
                
                T top = m[first][i];

                // left -> top
                m[first][i] = m[last - offset][first];
                // bottom -> left
                m[last - offset][first] = m[last][last - offset];
                // right -> bottom
                m[last][last - offset] = m[i][last];
                // top -> right
                m[i][last] = top;
            }
        }
    }

    public static void expandZeroes(int[][] m) {
        boolean[] row = new boolean[m.length];
        boolean[] column = new boolean[m[0].length];

        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                if(m[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                if(row[i] || column[j]) {
                    m[i][j] = 0;
                }
            }
        }        
    }

    private static int[][] borderToTheRight(int[][] a, int border) {
        int[][] borderRight = new int[a.length][a.length];

        for(int i = 0; i < a.length; i++) {
            borderRight[i][a.length - 1] = a[i][a.length - 1] == border ? 1 : 0;
        }

        for(int i = 0; i < a.length; i++) {
            for(int j = a.length - 2; j >= 0; j--) {
                if(a[i][j] == border) {
                    borderRight[i][j] = 1 + borderRight[i][j+1];
                } else {
                    borderRight[i][j] = 0;
                }
            }
        }
        return borderRight;
    }

    private static int[][] borderToTheDown(int[][] a, int border) {
        int[][] borderDown = new int[a.length][a.length];

        for(int j = 0; j < a.length; j++) {
            borderDown[a.length - 1][j] = a[a.length - 1][j] == border ? 1 : 0;
        }

        for(int i = a.length - 2; i >= 0; i--) {
            for(int j = 0; j < a.length; j++) {
                if(a[i][j] == border) {
                    borderDown[i][j] = 1 + borderDown[i+1][j];
                } else {
                    borderDown[i][j] = 0;
                }
            }
        }
        return borderDown;
    }
    
    // assumptions: matrix is square
    public static int maximumSubarrayWithBorder(int[][] a, int border) {
        int[][] borderRight = borderToTheRight(a, border);
        int[][] borderDown = borderToTheDown(a, border);

        for(int n = a.length; n > 0; n--) {
            for(int i = 0; i < a.length - n + 1; i++) {
                for(int j = 0; j < a[i].length - n + 1; j++) {
                    boolean hborder = borderRight[i][j] >= n && borderRight[i + n - 1][j] >= n;
                    boolean vborder = borderDown[i][j] >= n && borderDown[i][j + n - 1] >= n;

                    if(hborder && vborder) {
                        return n;
                    }
                }
            }
        }
        
        return 0;
    }

    static int[][] preComputeSums(int[][] a) {
        int[][] sum = new int[a.length][a[0].length];

        sum[0][0] = a[0][0];
        
        for(int i = 1; i < a.length; i++) {
            sum[i][0] = sum[i-1][0] + a[i][0];
        }

        for(int j = 1; j < a[0].length; j++) {
            sum[0][j] = sum[0][j-1] + a[0][j];
        }

        for(int i = 1; i < a.length; i++) {
            for(int j = 1; j < a[0].length; j++) {
                sum[i][j] = a[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        return sum;
    }
    
    public static int maximumSubarraySum(int[][] a) {
        int[][] partial = preComputeSums(a);
        int max = 0;
        
        for(int top = 0; top < a.length; top++) {
        	for(int bottom = 0; bottom < a.length; bottom++) {
        		for(int left = 0; left < a[top].length; left++) {
        			for(int right = 0; right < a[top].length; right++) {
                        int sum = partial[bottom][right];
                        int above = top > 0 ? partial[top -1][right] : 0;
                        int toTheLeft = left > 0 ? partial[bottom][left -1] : 0;
                        int diagonal = top > 0 && left > 0 ? partial[top-1][left-1] : 0;
                        max = java.lang.Math.max(max, sum - above - toTheLeft + diagonal);
                    }
                }
            }
        }

        return max;
    }
}
