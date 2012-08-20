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

    public static int insert(int n, int m, int start, int end) {
        int left = ~0 << (end+1);
        int right = (1 << start) - 1;
        return (n & (left | right)) | (m << start);
    }

    public static int numberOfDifferentBits(int b1, int b2) {
        return countBitsSparse(b1 ^ b2);
    }

    public static int max(int a, int b) {
    	return a - (((a-b) >> 31) & (a - b));
    }

    public static int sum(int a, int b) {
        while(b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }  
    
    // assumption: each element appears twice except one
    public static int appearsOnceRestTwice(int[] a) {
    	int result = a[0];
    	for(int i = 1; i < a.length; i++) {
    		result ^= a[i];
    	}
    	return result;
    }
    
    // assumption: each element appears thrice except one
    public static int appearsOnceRestThrice(int[] a) {
    	int ones = 0;
    	int twos = 0;
    	for(int i = 0; i < a.length; i++) {
    		twos |= ones & a[i];
    		ones ^= a[i];
    		int not_three = ~(ones & twos);
    		ones &= not_three;
    		twos &= not_three;
    	}
    	return ones;    		
    }
    
    public static String printBinary(double num) {
    	StringBuilder b = new StringBuilder();
    	b.append(".");
    	while(num > 0) {
    		double r = num * 2;
    		
    		if(r >= 1) {
    			b.append("1");
    			num = r - 1;
    		} else {
    			b.append("0");
    			num = r;
    		}
    	}
    	return b.toString();
    }
    
    public static int getNextSameSetBits(int n) {
    	int c = n;
    	int c0 = 0;
    	int c1 = 0;
    	
    	while(((c & 1) == 0) && (c != 0)) {
    		c0++;
    		c >>= 1;
    	}
    	
    	while((c & 1) == 1) {
    		c1++;
    		c >>= 1;
    	}
    	
    	if(c0 + c1 == 31 || c0 + c1 == 0) {
    		return -1;
    	}
    	
    	int p = c0 + c1; // rightmost non-trailing zero
    	
    	n |= (1 << p); // flip rightmost non-trailing zero
    	n &= ~((1 << p) - 1); // clear all bits to the right of p
    	n |= (1 << (c1 - 1)) - 1; // Insert (c1-1) ones on the right
    	return n;
    }
}
