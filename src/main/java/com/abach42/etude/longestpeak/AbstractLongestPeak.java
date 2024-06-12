package com.abach42.etude.longestpeak;

public abstract class AbstractLongestPeak {
    protected int maxChainLength;
    protected int currentChainLength;

    abstract int findLongestPeak(int[] numbers);

    protected void reset() {
        maxChainLength = Math.max(maxChainLength, currentChainLength);
        currentChainLength = 1;
    }
}
