package com.hceris.trees;

public class HuffmanValue implements Comparable<HuffmanValue> {
    private final Character c;
    private final double frequency;

    public HuffmanValue(double frequency) {
        this(null, frequency);
    }
    
    public HuffmanValue(Character c, double frequency) {
        this.c = c;
        this.frequency = frequency;
    }

    public int compareTo(HuffmanValue v) {
        return Double.compare(frequency, v.frequency);
    }

    public char getCharacter() {
        return c == null ? ' ' : c;
    }

    public HuffmanValue combine(HuffmanValue v) {
        return new HuffmanValue(frequency + v.frequency);
    }
}
