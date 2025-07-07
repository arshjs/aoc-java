package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class D02Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(List<String> input, int expected) {
        Assertions.assertEquals(expected, D02.solutionPartOne(input));
    }

    @Test
    void testSolutionPartTwo() {
        // Puzzle 2
        Assertions.assertEquals(3842356, D02.solutionPartTwo(FileUtils.readFileAsList("y2015/D02.txt")));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of(List.of("2x3x4"), 58),
                Arguments.of(List.of("1x1x10"), 43),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsList("y2015/D02.txt"), 1606483)
        );
    }
}
