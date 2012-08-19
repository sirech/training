package com.hceris.math;

import com.google.common.base.Objects;

class Coefficient {
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
        return Objects.hashCode(n,k);
    }
}