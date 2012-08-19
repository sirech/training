package com.hceris.strings;

import java.util.Arrays;
import java.util.Comparator;

public class CareerCupStrings {
	
	private CareerCupStrings() {}

    private static class BiggestNumberComparator implements Comparator<String> {
        public int compare(String a, String b) {
            if(a.equals(b)) {
                return 0;
            }

            int i = 0;
            int j = 0;

            while(i < a.length() && j < b.length()) {
                if(a.charAt(i) > b.charAt(j)) {
                    return -1;
                }

                if(a.charAt(i) < b.charAt(j)) {
                    return 1;
                }

                i++;
                j++;
            }

            if(a.length() > b.length()) {
                return a.charAt(i) >= a.charAt(i-1) ? -1 : 1;
            }

            return b.charAt(j) >= b.charAt(j-1) ? 1 : -1;
        }
    }

    private static final BiggestNumberComparator biggestComparator = new BiggestNumberComparator();

    public static void biggestNumber(String[] a) {
        Arrays.sort(a, biggestComparator);
    }
}
