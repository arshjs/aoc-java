package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class D03Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(String input, int expected) {
        Assertions.assertEquals(expected, D03.solutionPartOne(input));
    }

    @ParameterizedTest
    @MethodSource("casesPartTwo")
    void testSolutionPartTwo(String input, int expected) {
        Assertions.assertEquals(expected, D03.solutionPartTwo(input));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of(">", 2),
                Arguments.of("^>v<", 4),
                Arguments.of("^v^v^v^v^v", 2),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsString("y2015/D03.txt"), 2572)
        );
    }

    private static Stream<Arguments> casesPartTwo() {
        return Stream.of(
                Arguments.of("^v", 3),
                Arguments.of("^>v<", 3),
                Arguments.of("^v^v^v^v^v", 11),

                // Puzzle 2
                Arguments.of(FileUtils.readFileAsString("y2015/D03.txt"), 2631)
        );
    }
}
