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
}
