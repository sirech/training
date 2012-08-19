package com.hceris.strings;

import java.util.Arrays;

public class CareerCupStrings {
	
	private CareerCupStrings() {}

    private static final BiggestNumberComparator biggestComparator = new BiggestNumberComparator();

    public static void biggestNumber(String[] a) {
        Arrays.sort(a, biggestComparator);
    }
}
