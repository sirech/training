package com.hceris.sort;

import static com.hceris.util.Utils.swap;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.hceris.datastructures.MinHeap;

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

        return -(left+1);
    }

    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T elem, int left, int right) {
        if(left > right) {
            return -(left+1);
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
        
        if(isSorted(a, left, middle - 1)) {
        	if(cmp < 0 && elem.compareTo(a[left]) >= 0) {
        		return binarySearch(a, elem, left, middle - 1);
        	} else {
        		return rotatedSearch(a, elem, middle + 1, right);
        	}
        } else {
            if(cmp > 0 && elem.compareTo(a[right]) <= 0) {
        		return binarySearch(a, elem, middle + 1, right);
        	} else {
        		return rotatedSearch(a, elem, left, middle - 1);
        	}
        }
    }

    public static <T extends Comparable<? super T>> int rotatedMin(T[] a) {
        return rotatedMin(a, 0, a.length - 1);
    }

    public static <T extends Comparable<? super T>> int rotatedMin(T[] a, int left, int right) {
        if(left >= right) {
            return left;
        }

        int middle = (left + right) >>> 1;

        int left_min = isSorted(a, left, middle) ? left : rotatedMin(a, left, middle);
        int right_min = isSorted(a, middle + 1, right) ? middle + 1 : rotatedMin(a, middle + 1, right);

        return a[left_min].compareTo(a[right_min]) <= 0 ? left_min : right_min;
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

    public static int[] minTriplet(int[] a, int[] b, int[] c) {
        int i = 0;
        int j = 0;
        int k = 0;
        int minThusFar = Integer.MAX_VALUE;
        int[] triplet = new int[3];

        while(i < a.length && j < b.length && k < c.length) {
            int dist = Math.max(Math.max(Math.abs(a[i] - b[j]), Math.abs(b[j] - c[k])), Math.abs(a[i] - c[k]));
            if(dist < minThusFar) {
                minThusFar = dist;
                triplet[0] = i;
                triplet[1] = j;
                triplet[2] = k;
            }

            int m = Math.min(Math.min(a[i], b[j]), c[k]);
            if(m == a[i] ) {
                i++;
            } else if(m == b[j]) {
                j++;
            } else {
                k++;
            }
        }
        return triplet;
    }

    public static <T extends Comparable<? super T>> int[] searchSortedMatrix(T[][] m, T elem) {
        int i = 0;
        int j = m[0].length - 1;

        while(i < m.length && j >= 0) {
            int cmp = elem.compareTo(m[i][j]);

            if(cmp == 0) {
                return new int[] {i, j};
            } else if(cmp < 0) {
                j--;
            } else {
                i++;
            }
        }

        return new int[] { -1, -1 };
    }
    
    public static <T extends Comparable<? super T>> int insertionPoint(T[] a, T elem) {
    	int pos = binarySearch(a, elem);
    	Preconditions.checkState(pos < 0);
    	return -(pos + 1);
    }

    // assumptions: array not sorted, modifying it is acceptable
    public static <T extends Comparable<? super T>> T nthElement(T[] a, int k) {
    	int left = 0;
    	int right = a.length - 1;
    	
    	while(left <= right) {
    		swap(a, left, pivot(a, left, right));
    		int middle = left;
    		
    		for(int i = left + 1; i <= right; i++) {
    			if(a[i].compareTo(a[left]) <= 0) {
    				swap(a, i, ++middle);
    			}
    		}
    		swap(a, left, middle);
    		
    		if(k == middle) {
    			return a[k];
    		} else if(k < middle) {
    			right = middle - 1;
    		} else {
    			left = middle + 1;
    		}    		
    	}
    	
    	return null;
    }
    
    private static <T extends Comparable<? super T>> int pivot(T[] a, int left, int right) {
    	return left;
    }
    
    // assumptions: Each row is sorted, each column is sorted
    public static <T extends Comparable<? super T>> T nthElement(T[][] a, int k) {
    	Set<Cell<T>> seen = new HashSet<Cell<T>>();
    	MinHeap<Cell<T>> heap = new MinHeap<Cell<T>>(k + 1);
    	
    	Cell<T> origin = new Cell<T>(0, 0, a[0][0]);
    	seen.add(origin);
    	heap.offer(origin);
    	int counter = 0;
    	
    	while(counter <= k && !heap.isEmpty()) {
    		Cell<T> current = heap.poll();
    		    		
    		if(counter == k) {
    			return current.value;
    		}
    		
    		counter++;
    		
    		if(current.x < a.length - 1) {
    			Cell<T> down = new Cell<T>(current.x + 1, current.y, a[current.x + 1][current.y]);
    			if(seen.add(down)) {
    				heap.offer(down);
    			}
    		}
    		
    		if(current.y < a[0].length - 1) {
    			Cell<T> right = new Cell<T>(current.x, current.y + 1, a[current.x][current.y + 1]);
    			if(seen.add(right)) {
    				heap.offer(right);
    			}
    		}
    	}
    	
    	throw new IllegalStateException("Not enough elements in the heap");
    }
    
    public static <T extends Comparable<? super T>> int occurences(T[] a, T elem) {
    	int rightSearch = rightSearch(a, elem, 0, a.length -1);
		int leftSearch = leftSearch(a, elem, 0, a.length - 1);
		return (rightSearch < 0 || leftSearch < 0) ? 0 : rightSearch -  leftSearch + 1;
    }
    
    private static <T extends Comparable<? super T>> int leftSearch(T[] a, T elem, int left, int right) {
    	if(left > right) { return -1; }
    	
    	while(left < right) {
    		int middle = (left + right) >>> 1;
    		int cmp = elem.compareTo(a[middle]);
    		
    		if(cmp == 0) {
    			right = middle;
    		} else if(cmp < 0) {
    			right = middle - 1;
    		} else {
    			left = middle + 1;
    		}
    	}
    	
    	return elem.compareTo(a[left]) == 0 ? left: -1;
    }
    
    private static <T extends Comparable<? super T>> int rightSearch(T[] a, T elem, int left, int right) {
    	if(left > right) { return -1; }
    	
    	if(left == right) {
    		return elem.compareTo(a[left]) == 0 ? left : -1;
    	}
    	
    	while(left < right - 1) {
    		int middle = (left + right) >>> 1;
    		int cmp = elem.compareTo(a[middle]);
    		
    		if(cmp == 0) {
    			left = middle;
    		} else if(cmp < 0) {
    			right = middle - 1;
    		} else {
    			left = middle + 1;
    		}
    	}
    	
    	return elem.compareTo(a[right]) == 0 ? right:
    			elem.compareTo(a[left]) == 0 ? left : 
    				-1;
    }    
}
