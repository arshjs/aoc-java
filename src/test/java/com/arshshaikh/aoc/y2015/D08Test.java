package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class D08Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(List<String> input, int expected) {
        Assertions.assertEquals(expected, D08.solutionPartOne(input));
    }

    @ParameterizedTest
    @MethodSource("casesPartTwo")
    void testSolutionPartTwo(List<String> input, int expected) {
        Assertions.assertEquals(expected, D08.solutionPartTwo(input));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of(List.of("\"\""), 2),
                Arguments.of(List.of("\"abc\""), 2),
                Arguments.of(List.of("\"aaa\\\"aaa\""), 3),
                Arguments.of(List.of("\"\\x27\""), 5),
                Arguments.of(List.of("\"\"", "\"abc\"", "\"aaa\\\"aaa\"", "\"\\x27\""), 12),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsList("y2015/D08.txt"), 1342)
        );
    }

    private static Stream<Arguments> casesPartTwo() {
        return Stream.of(
                Arguments.of(List.of("\"\""), 4),
                Arguments.of(List.of("\"abc\""), 4),
                Arguments.of(List.of("\"aaa\\\"aaa\""), 6),
                Arguments.of(List.of("\"\\x27\""), 5),
                Arguments.of(List.of("\"\"", "\"abc\"", "\"aaa\\\"aaa\"", "\"\\x27\""), 19),

                // Puzzle 2
                Arguments.of(FileUtils.readFileAsList("y2015/D08.txt"), 2074)
        );
    }
}
