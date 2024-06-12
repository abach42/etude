package com.abach42.etude.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciLoopGenerator implements FibonacciList {

    private List<Integer> generateFibonacci(int operations) {
        List<Integer> chain = new ArrayList<>(Arrays.asList(-1, 1));

        for (int i = 0; i <= operations; i++) {
            chain.add(chain.get(chain.size() - 1) + chain.get(chain.size() - 2));
        }

        return chain.subList(2, chain.size());
    }

    @Override
    public List<Integer> getIntegerList(int numberOfOperations) {
        return generateFibonacci(numberOfOperations);
    }
}
