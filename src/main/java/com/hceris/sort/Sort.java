package com.hceris.sort;

import static com.hceris.util.Utils.swap;

public class Sort {
    private Sort() {}

    public static <T extends Comparable<? super T>> void quickSort(T[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static <T extends Comparable<? super T>> void quickSort(T[] a, int left, int right) {
        if(left >= right) { return; }

        int middle = partition(a, left, right);
        quickSort(a, left, middle - 1);
        quickSort(a, middle + 1, right);
    }

    private static <T extends Comparable<? super T>> int partition(T[] a, int left, int right) {
        swap(a, left, pivot(a, left, right));
        int middle = left;

        for(int i = middle + 1; i <= right; i++) {
            if(a[i].compareTo(a[left]) <= 0) {
                swap(a, i, ++middle);
            }
        }
        swap(a, middle, left);
        return middle;
    }

    private static <T extends Comparable<? super T>> int pivot(T[] a, int left, int right) {
        return left;
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] a) {
        @SuppressWarnings("unchecked")
		T[] aux = (T[]) new Comparable[a.length];
        mergeSort(a, aux, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] aux, int left, int right) {
        if(left >= right) {
            return;
        }

        int middle = (left + right) >>> 1;
        mergeSort(a, aux, left, middle);
        mergeSort(a, aux, middle + 1, right);
        merge(a, aux, left, middle, right);
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int left, int leftEnd, int rightEnd) {
        int i = left;
        int j = leftEnd + 1;
        int k = left;

        while(i <= leftEnd && j <= rightEnd) {
            if(a[i].compareTo(a[j]) <= 0) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
            }
        }

        while(i <= leftEnd) {
            aux[k++] = a[i++];
        }

        while(j <= rightEnd) {
            aux[k++] = a[j++];
        }

        for(k = left; k <= rightEnd; k++) {
        	a[k] = aux[k];
        }           
    }

    // similar to partition for quicksort which doesn't rearrange duplicated elements
	public static void dutchFlagSort(int[] a, int p, int k) {
		int p_index = 0;
		int k_index = a.length - 1;
		for (int i = 0; i <= k_index;) {
			if (a[i] < p) {
				swap(a, i, p_index);
				p_index++;
				i++;
			} else if (a[i] >= k) {
				swap(a, i, k_index);
				k_index--;
			} else {
				i++;
			}
		}
	}


    @SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> int countInversions(T[] a) {
        return countInversions(a, (T[]) new Comparable[a.length], 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> int countInversions(T[] a, T[] tmp, int left, int right) {
        if(left >= right) { return 0; }

        int middle = (left + right) >>> 1;
        int inversions = countInversions(a, tmp, left, middle);
        inversions += countInversions(a, tmp, middle + 1, right);

        inversions += mergeAndCountInversions(a, tmp, left, middle, right);
        return inversions;
    }

    private static <T extends Comparable<? super T>> int mergeAndCountInversions(T[] a, T[] tmp, int left, int leftEnd, int right) {
        int inversions = 0;
        int i = left;
        int j = leftEnd + 1;
        int k = left;

        while(i <= leftEnd && j <= right) {
            if(a[i].compareTo(a[j]) <= 0) {
                tmp[k++] = a[i++];
            } else {
                inversions += (leftEnd - i + 1);
                tmp[k++] = a[j++];
            }
        }

        while(i <= leftEnd) {
            tmp[k++] = a[i++];
        }

        while(j <= right) {
            tmp[k++] = a[j++];
        }

        for(k = left; k <= right; k++) {
            a[k] = tmp[k];
        }

        return inversions;
    }
}
