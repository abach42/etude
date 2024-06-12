package com.abach42.etude.fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FibonacciGeneratorTest {

    @ParameterizedTest(name = "{1} fibonacci operation/s result ''{0}''")
    @MethodSource("testCases")
    @DisplayName("Test fibonacci using loop")
    public void testFibonacciLoop(List<Integer> expected, int operations) {
        assertEquals(expected, new FibonacciLoopGenerator().getIntegerList(operations));
    }

    @ParameterizedTest(name = "{1} fibonacci operation/s result ''{0}''")
    @MethodSource("testCases")
    @DisplayName("Test fibonacci using stream")
    public void testFibonacciStream(List<Integer> expected, int operations) {
        assertEquals(expected, new FibonacciStreamGenerator().getIntegerList(operations));
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(List.of(0), 0),
                Arguments.of(Arrays.asList(0, 1), 1),
                Arguments.of(Arrays.asList(0, 1, 1), 2),
                Arguments.of(Arrays.asList(0, 1, 1, 2), 3),
                Arguments.of(Arrays.asList(0, 1, 1, 2, 3), 4),
                Arguments.of(Arrays.asList(0, 1, 1, 2, 3, 5), 5),
                Arguments.of(Arrays.asList(0, 1, 1, 2, 3, 5, 8), 6),
                Arguments.of(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13), 7),
                Arguments.of(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21), 8),
                Arguments.of(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), 9),
                Arguments.of(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 10)
        );
    }
}
