package com.abach42.etude.longestpeak;

public class LongestPeakSpaceship extends AbstractLongestPeak {
    @Override
    public int findLongestPeak(int[] numbers) {
        return findBySpaceship(numbers);
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
}
