package com.abach42.etude.number_chain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LongestChainFinderTest {

    private LongestPeakFinder subject = new LongestPeakFinder();

    @ParameterizedTest(name = "{index} ==> the longest chain in ''{0}'' is {1}")
    @MethodSource("testCases")
    @DisplayName("Test find longest peak by pointer")
    public void testFindByPointer(int[] numbers, int expected) {
        assertEquals(expected, subject.findByPointer(numbers));
    }

    @ParameterizedTest(name = "{index} ==> the longest chain in ''{0}'' is {1}")
    @MethodSource("testCases")
    @DisplayName("Test find longest peak by Spaceship <=>")
    public void testFindLongestPeak(int[] numbers, int expected) {
        assertEquals(expected, subject.findBySpaceship(numbers));
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(new int[]{5}, 1),
            Arguments.of(new int[]{1, 1}, 1),
            Arguments.of(new int[]{1, 2}, 2),
            Arguments.of(new int[]{1, 2, 3}, 3),
            Arguments.of(new int[]{3, 2, 1}, 3),
            Arguments.of(new int[]{3, 2, 1, 2}, 3),
            Arguments.of(new int[]{1, 2, 3, 3}, 3),
            Arguments.of(new int[]{1, 1, 2, 3}, 3),
            Arguments.of(new int[]{1, 2, 1, 2, 1}, 3),
            Arguments.of(new int[]{0, 1, 2, 3, 3, 4, 0, 6, 10, 8, 5, 2, 3, 4}, 6)
        );
    }
}