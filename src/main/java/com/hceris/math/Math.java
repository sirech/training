package com.hceris.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.primitives.Ints;
import com.hceris.util.Utils;

public class Math {
    private Math() {}

    public static int binomialCoefficient(int n, int k) {
        return binomialCoefficient(n, k, new HashMap<Coefficient, Integer>());
    }

    private static int binomialCoefficient(int n, int k, Map<Coefficient, Integer> cache) {
        if(k == 0 || k == n)
            return 1;

        if(n == 0)
            return 0;

        Coefficient c = new Coefficient(n, k);
        if(cache.containsKey(c)) {
            return cache.get(c);
        }

        int result = binomialCoefficient(n - 1, k, cache) + binomialCoefficient(n - 1, k - 1, cache);
        cache.put(c, result);
        return result;
    }

    public static int fibonacci(int n) {
        int a = 0;
        int b = 1;

        for(int i = 1; i <= n; i++) {
            int tmp = a + b;
            b = a;
            a = tmp;
        }

        return a;
    }

    public static int random(int a, int b) {
        return random(b - a) + a;
    }

    public static int random(int n) {
        Random rnd = new Random();

        int bits = 0;
        while((1 << bits) < n) {
            bits++;
        }

        while(true) {
            int number = 0;
            for(int i = 0; i < bits; i++) {
                if(rnd.nextBoolean()) {
                    number |= 1 << i;
                }
            }

            if(number < n) {
                return number;
            }
        }
    }

    // assumption: array unsorted
    public static int[] twoSum(int[] a, int target) {
        Map<Integer,Integer> available = new HashMap<Integer,Integer>();

        for(int i = 0; i < a.length; i++) {
            Integer index = available.get(target - a[i]);
            if(index != null) {
                return new int[] { index, i };
            }

            available.put(a[i], i);
        }

        return new int[] {};
    }
    
    // assumption: array unsorted
    public static int[] threeSum(int[] a) {
        if(a.length < 3) {
            return new int[] {};
        }

        Arrays.sort(a);

        for(int i = 0; i < a.length - 2; i++) {
            int l = i + 1;
            int r = a.length - 1;

            while(l < r) {
                int sum = a[i] + a[l] + a[r];

                if(sum == 0) {
                    return new int[] {i, l, r};
                } else if(sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return new int[] {};
    }

    public static int[] threeSumClosest(int[] a, int target) {
        if(a.length < 3) {
            return new int[] {};
        }

        Arrays.sort(a);
        int[] best = new int[] {};
        int delta = Integer.MAX_VALUE;

        for(int i = 0; i < a.length - 2; i++) {
            int l = i + 1;
            int r = a.length - 1;

            while(l < r) {
                int sum = a[i] + a[l] + a[r] - target;

                if(sum == 0) {
                    return new int[] {i, l, r};
                } else {
                    if(java.lang.Math.abs(sum) < delta) {
                        delta = java.lang.Math.abs(sum);
                        best = new int[] {i, l, r};
                    }
                    
                    if(sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return best;
    }

    // assumption: unsorted array, contains negative and positive numbers
    public static int[] subSetSum(int[] a, int target) {
        int min = Utils.min(a);
        int max = Utils.max(a);

        Map<List<Integer>, Boolean> cache = new HashMap<List<Integer>, Boolean>();

        for(int i = 0; i < a.length; i++) {
            if(subSetSum(a, target, min, max, i, cache)) {
                return reconstruct(a, target, i, cache);
            }
        }

        return new int[] {};
    }

    private static boolean subSetSum(int[] a, int target, int min, int max, int i, Map<List<Integer>, Boolean> cache) {
        if(target < min || target > max) {
            return false;
        }

        if(i < 0 || i >= a.length) {
            return false;
        }

        Boolean hasSubset = cache.get(Arrays.asList(i, target));
        if(hasSubset != null) {
            return hasSubset;
        }

        boolean result = a[i] == target ||
            subSetSum(a, target, min, max, i-1, cache) ||
            subSetSum(a, target - a[i], min, max, i-1, cache);

        cache.put(Arrays.asList(i, target), result);
        return result;
    }

    private static int[] reconstruct(int[] a, int target, int i, Map<List<Integer>, Boolean> cache) {
        LinkedList<Integer> result = new LinkedList<Integer>();

        while(i >= 0) {
        	if(a[i] == target) {
        		result.addFirst(i);
        		break;
        	}
        	
        	Boolean isThere = cache.get(Arrays.asList(i-1, target));
        	if(isThere != null && isThere) {
                i--;
            } else {
                result.addFirst(i);
                target -= a[i];
                i--;
            }            
        }
        return Ints.toArray(result);
    }

    public static int divide(int a, int b) {
        boolean positive = (a > 0 && b > 0) || (a < 0 && b < 0);
        a = java.lang.Math.abs(a);
        b = java.lang.Math.abs(b);

        int res = 0;
        while(a >= b) {
            res++;
            a -= b;
        }

        return positive ? res : -res;
    }

    public static long pow(long x, int n) {
        if(n == 0) {
            return 1;
        }
        if(x == 0 || n == 1) {
            return x;
        }
        
        long result = 1;
        boolean isNeg = n < 0;
        n = java.lang.Math.abs(n);
        
        while(n > 0) {
          if((n & 1) != 0) {
             result *= x;
             n--;
          }    
          x *= x;
          n /= 2;
        }
        
        return isNeg ? 1 / result : result;
    }
    
    public static int countZeroesInFactorial(int n) {
    	int count = 0;
    	for(int i = 5; n / i > 0; i *= 5) {
    		count += n / i;
    	}
    	return count;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
