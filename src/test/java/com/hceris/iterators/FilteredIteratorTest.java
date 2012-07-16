package com.hceris.iterators;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;

public class FilteredIteratorTest {
    private Predicate<Integer> even = new Predicate<Integer>() {
        public boolean apply(Integer i) { return i % 2 == 0; }
    };

    @Test public void testNext() throws Exception {
        List<Integer> original = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        FilteredIterator<Integer> it = new FilteredIterator<Integer>(original.iterator(), even);


        assertEquals((int)it.next(), 2);
        assertEquals((int)it.next(), 4);
        assertEquals((int)it.next(), 6);
        assertEquals((int)it.next(), 8);
        assertEquals((int)it.next(), 10);
    }

    @Test public void testHasNext() throws Exception {
        FilteredIterator<Integer> it = new FilteredIterator<Integer>(Arrays.asList(1,3,5,7,8,9).iterator(), even);
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }
}
