package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class D01Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(String input, int expected) {
        Assertions.assertEquals(expected, D01.solutionPartOne(input));
    }

    @ParameterizedTest
    @MethodSource("casesPartTwo")
    void testSolutionPartTwo(String input, int expected) {
        Assertions.assertEquals(expected, D01.solutionPartTwo(input));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of("(())", 0),
                Arguments.of("()()", 0),
                Arguments.of("(((", 3),
                Arguments.of("(()(()(", 3),
                Arguments.of("))(((((", 3),
                Arguments.of("())", -1),
                Arguments.of("))(", -1),
                Arguments.of(")))", -3),
                Arguments.of(")())())", -3),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsString("y2015/D01.txt"), 74)
        );
    }

    private static Stream<Arguments> casesPartTwo() {
        return Stream.of(
                Arguments.of(")", 1),
                Arguments.of("()())", 5),

                // Puzzle 2
                Arguments.of(FileUtils.readFileAsString("y2015/D01.txt"), 1795)
        );
    }
}
