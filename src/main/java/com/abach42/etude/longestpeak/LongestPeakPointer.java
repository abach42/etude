package com.abach42.etude.longestpeak;

public class LongestPeakPointer extends AbstractLongestPeak {
    @Override
    public int findLongestPeak(int[] numbers) {
        return findByPointer(numbers);
    }

    private int findByPointer(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        maxChainLength = 1;
        currentChainLength = 1;

        boolean continueCounting = true;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                if (!continueCounting) {
                    reset();
                }
                continueCounting = true;
                currentChainLength++;
            }

            if (numbers[i] < numbers[i - 1]) {
                continueCounting = false;
                currentChainLength++;
            } 

            if (numbers[i] == numbers[i - 1]) {
                reset();
                continueCounting = true;
            }
        }

        return Math.max(maxChainLength, currentChainLength);
    }
}
