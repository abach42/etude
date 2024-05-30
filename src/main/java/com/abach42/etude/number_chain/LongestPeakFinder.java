package com.abach42.etude.number_chain;

public class LongestPeakFinder {
    private int maxChainLength;
    private int currentChainLength;

    public int findByPointer(int[] numbers) {
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

    public int findBySpaceship(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        maxChainLength = 1;
        currentChainLength = 1;

        boolean wasDownward = false;

        for (int i = 0; i < numbers.length - 1; i++) { 
            int movement = Integer.compare(numbers[i + 1], numbers[i]); 

            if (movement == 1) {
                // up
                if (wasDownward) {
                    // down and up, valley
                    reset(); 
                }
                wasDownward = false; 
                currentChainLength++;
            } 
            
            if (movement == -1) {
                // down
                wasDownward = true;
                currentChainLength++;
            } 
            
            if (movement == 0) { 
                // equal
                reset();
                wasDownward = false; 
            }
        }

        return Math.max(maxChainLength, currentChainLength);
    }

    private void reset() {
        maxChainLength = Math.max(maxChainLength, currentChainLength);
        currentChainLength = 1;
    }
}
