package com.hceris.dp;

public class CareerCupDP {

	private CareerCupDP() {}
	
	// find (i,j) such that A[i] < A[j] and (j-1) is maximum
	public static int[] maxDistance(int[] a) {
		int[] smallestLeft = new int[a.length];
		int[] biggestRight = new int[a.length];
		
		smallestLeft[0] = a[0];
		for(int i = 1; i < a.length; i++) {
			smallestLeft[i] = Math.min(a[i], smallestLeft[i-1]);
		}
		
		biggestRight[a.length - 1] = a[a.length - 1];
		for(int i = a.length - 2; i >= 0; i--) {
			biggestRight[i] = Math.max(a[i], biggestRight[i+1]);
		}
		
		int maxdiff = 0;
		int[] pair = new int[] {};
		
		for(int i = 0, j = 0; i < a.length && j < a.length ;) {
			if(smallestLeft[i] < biggestRight[j]) {
				if(j - 1 > maxdiff) {
					maxdiff = j - 1;
					pair = new int[] { i, j };
				}
				j++;
			} else {
				i++;
			}
		}
		return pair;
	}
}
