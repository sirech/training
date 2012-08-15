package com.hceris.sort;

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

    private static <T> void swap(T[] a, int x, int y) {
        T tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
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

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
