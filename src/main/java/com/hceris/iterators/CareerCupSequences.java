package com.hceris.iterators;

import static com.hceris.util.Utils.swap;

import com.hceris.util.Utils;

public class CareerCupSequences {
	private CareerCupSequences() {}
	
	public static boolean isSequence(int[] a) {
		int min = Utils.min(a);
		int max = Utils.max(a);
		
		if(a.length < (max - min + 1)) {
			return false;
		}
		
		for(int i = 0; i < a.length; i++) {
			while(true) {
				// Dupl
				if(min > a[i]) {
					break;
				}
				
				// Right place
				if(a[i] == a[a[i] - min]) {
					
					// Mark as dupl
					if(i != a[i] - min) {
						a[i] = min - a[i];
					}
					break;
			    // Swap to right position
				} else {
					swap(a, i, a[i] - min);
				}
			}
		}
				
		for(int i = 0; i < a.length; i++) {
			if(a[i] < min) {
				while(i < a.length) {
					if(a[i] >= min) {
						return false;
					}
					i++;
				}
				return true;
			}
			if(i > 0 && a[i] - a[i-1] != 1) {
				return false;
			}
		}
		return true;
	}
}
