package com.hceris.bytes;

public class Bytes {
    private Bytes() {}

    public static final int MASK1 = 0x55555555;
    public static final int MASK2 = 0x33333333;
    public static final int MASK4 = 0x0F0F0F0F;
    public static final int MASK8 = 0x00FF00FF;
    public static final int MASK16 = 0x0000FFFF;

    public static boolean isPowerOfTwo(int n) {
        return (n & (n-1)) == 0;
    }

    public static int countBitsSparse(int b) {
        int count = 0;
        while(b != 0) {
            b = b & (b-1);
            count++;
        }
        return count;
    }

    public static int countBits(int b) {
        b = ((b >>> 1) & MASK1) + (b & MASK1);
        b = ((b >>> 2) & MASK2) + (b & MASK2);
        b = ((b >>> 4) & MASK4) + (b & MASK4);
        b = ((b >>> 8) & MASK8) + (b & MASK8);
        return ((b >>> 16) & MASK16) + (b & MASK16);
    }

    public static int reverse(int b) {
        b = ((b >>> 1) & MASK1) | ((b & MASK1) << 1);
        b = ((b >>> 2) & MASK2) | ((b & MASK2) << 2);
        b = ((b >>> 4) & MASK4) | ((b & MASK4) << 4);
        b = ((b >>> 8) & MASK8) | ((b & MASK8) << 8);
        return ((b >>> 16) & MASK16) | ((b & MASK16) << 16);
    }
}
