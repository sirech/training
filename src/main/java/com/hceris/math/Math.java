package com.hceris.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

    private static class Coefficient {
        final int n;
        final int k;

        Coefficient(int n, int k) {
            this.n = n;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;

            if (!(o instanceof Coefficient))
                return false;

            Coefficient c = (Coefficient) o;
            return n == c.n && k == c.k;
        }

        @Override
        public int hashCode() {
            return n ^ k;
        }
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
}
