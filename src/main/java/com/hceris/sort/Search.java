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

    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T elem, int left, int right) {
        if(left > right) {
            return -1;
        }

        int middle = (left + right) >>> 1;
        int cmp = elem.compareTo(a[middle]);

        if(cmp == 0) {
            return middle;
        } else if (cmp < 0) {
            return binarySearch(a, elem, left, middle - 1);
        } else {
            return binarySearch(a, elem, middle + 1, right);
        }
    }

    public static <T extends Comparable<? super T>> int rotatedSearch(T[] a, T elem) {
        return rotatedSearch(a, elem, 0, a.length - 1);
    }

    public static <T extends Comparable<? super T>> int rotatedSearch(T[] a, T elem, int left, int right) {
        if(left > right) {
            return -1;
        }

        int middle = (left + right) >>> 1;
        int cmp = elem.compareTo(a[middle]);

        if(cmp == 0) {
            return middle;
        }

        int left_res = -1;
        if(isSorted(a, left, middle - 1)) {
            if(cmp < 0) {
                left_res = binarySearch(a, elem, left, middle - 1);
            }
        } else {
            left_res = rotatedSearch(a, elem, left, middle - 1);
        }

        if(left_res != -1) {
            return left_res;
        }

        int right_res = -1;
        if(isSorted(a, middle - 1, right)) {
            if(cmp > 0) {
                right_res = binarySearch(a, elem, middle + 1, right);
            }
        } else {
            right_res = rotatedSearch(a, elem, middle + 1, right);
        }

        return right_res;
    }

    private static <T extends Comparable<? super T>> boolean isSorted(T[] a, int left, int right) {
        return a[left].compareTo(a[right]) <= 0;
    }

    public static int binarySearchWithEmpty(String[] a, String elem) {
        return binarySearchWithEmpty(a, elem, 0, a.length - 1);
    }

    public static int binarySearchWithEmpty(String[] a, String elem, int left, int right) {
        if(left > right) { return -1; }

        int middle = (left + right) >>> 1;
        while(middle >= 0 && a[middle].isEmpty()) {
            middle--;
        }

        int cmp = elem.compareTo(a[middle]);

        if(cmp == 0) {
            return middle;
        } else if (cmp < 0) {
            return binarySearchWithEmpty(a, elem, left, middle - 1);
        } else {
            return binarySearchWithEmpty(a, elem, Math.max(middle, (left + right) >>> 1) + 1, right);
        }
    }

    public static int squareRoot(int n) {
        int left = 0;
        int right = (1 << 16) - 1;

        while(left <= right) {
            int middle = (left + right) >>> 1;
            int square = middle * middle;

            if(square == n) {
                return middle;
            } else if(n < square) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }

    public static <T extends Comparable<? super T>> int maxLessThan(T[] a, T max) {
        int left = 0;
        int right = a.length - 1;
        int maxThusFar = -1;

        while(left <= right) {
            int middle = (left + right) >>> 1;
            int cmp = max.compareTo(a[middle]);

            if(cmp == 0) {
                return middle;
            } else if (cmp < 0) {
                right = middle -  1;
            } else {
                maxThusFar = middle;
                left = middle + 1;
            }
        }
        
        return maxThusFar;
    }

    public static <T extends Comparable<? super T>> T[] maxmin(T[] a) {
        return maxmin(a, 0, a.length - 1);
    }

    @SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> T[] maxmin(T[] a, int left, int right) {
        if(left > right) { return (T[]) new Comparable[] {}; }
        else if(left == right) { return (T[]) new Comparable[] { a[left], a[right] }; }
        else if(left + 1 == right) {
            if(a[left].compareTo(a[right]) <= 0) {
                return (T[]) new Comparable[] { a[left], a[right] };
            } else {
                return (T[]) new Comparable[] { a[right], a[left] };
            }
        }

        int middle = (left + right) >>> 1;
        T[] left_res = maxmin(a, left, middle);
        T[] right_res = maxmin(a, middle + 1, right);
        
        T min = left_res[0].compareTo(right_res[0]) <= 0 ? left_res[0] : right_res[0];
        T max = left_res[1].compareTo(right_res[1]) >= 0 ? left_res[1] : right_res[1];
        return (T[]) new Comparable[] { min, max };
    }
}
