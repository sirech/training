package com.hceris.math;

import java.util.HashMap;
import java.util.Map;

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
}
