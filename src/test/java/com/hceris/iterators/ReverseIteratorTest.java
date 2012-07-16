package com.hceris.iterators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ReverseIteratorTest {

    @Test public void testNext() throws Exception {
        List<Integer> original = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ReverseIterator<Integer> it = new ReverseIterator<Integer>(original);

        assertEquals((int)it.next(), 10);
        assertEquals((int)it.next(), 9);
        assertEquals((int)it.next(), 8);
        assertEquals((int)it.next(), 7);
    }

    @Test public void testHasNext() throws Exception {
        List<Integer> original = Arrays.asList(1);
        ReverseIterator<Integer> it = new ReverseIterator<Integer>(original);

        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }
}
