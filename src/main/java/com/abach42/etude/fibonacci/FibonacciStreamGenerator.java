package com.abach42.etude.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FibonacciStreamGenerator implements FibonacciList {

    private List<Integer> generateFibonacci(int operations) {
        List<Integer> chain = new ArrayList<>(List.of(0));

        Stream.iterate(new int[]{ 0, 1 }, pair -> new int[]{ pair[1], pair[0] + pair[1] })
                .limit(operations)
                .map(pair -> pair[1])
                .forEach(chain::add);

        return chain;
    }

    @Override
    public List<Integer> getIntegerList(int numberOfOperations) {
        return generateFibonacci(numberOfOperations);
    }
}
