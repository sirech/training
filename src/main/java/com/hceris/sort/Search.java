package com.hceris.sort;

public class Search {
    private Search() {}

    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T elem) {
        int left = 0;
        int right = a.length - 1;

        while(left <= right) {
            int middle = (left + right) >>> 1;
            int cmp = elem.compareTo(a[middle]);

            if(cmp == 0) {
                return middle;
            } else if (cmp < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
