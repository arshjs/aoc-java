package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class D04Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(String input, int expected) {
        Assertions.assertEquals(expected, D04.solutionPartOne(input));
    }

    @Test
    void testSolutionPartTwo() {
        // Puzzle 2
        Assertions.assertEquals(1038736, D04.solutionPartTwo(FileUtils.readFileAsString("y2015/D04.txt")));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of("abcdef", 609043),
                Arguments.of("pqrstuv", 1048970),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsString("y2015/D04.txt"), 254575)
        );
    }
}
