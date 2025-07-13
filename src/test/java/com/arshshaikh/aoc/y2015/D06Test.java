package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class D06Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(List<String> input, int expected) {
        Assertions.assertEquals(expected, D06.solutionPartOne(input));
    }

    @ParameterizedTest
    @MethodSource("casesPartTwo")
    void testSolutionPartTwo(List<String> input, int expected) {
        Assertions.assertEquals(expected, D06.solutionPartTwo(input));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of(List.of("turn on 0,0 through 999,999"), 1000000),
                Arguments.of(List.of("toggle 0,0 through 999,0"), 1000),
                Arguments.of(List.of("turn off 499,499 through 500,500"), 0),
                Arguments.of(List.of("turn on 0,0 through 999,999", "toggle 0,0 through 999,0", "turn off 499,499 through 500,500"), 998996),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsList("y2015/D06.txt"), 400410)
        );
    }

    private static Stream<Arguments> casesPartTwo() {
        return Stream.of(
                Arguments.of(List.of("turn on 0,0 through 0,0"), 1),
                Arguments.of(List.of("toggle 0,0 through 999,999"), 2000000),

                // Puzzle 2
                Arguments.of(FileUtils.readFileAsList("y2015/D06.txt"), 15343601)
        );
    }
}
