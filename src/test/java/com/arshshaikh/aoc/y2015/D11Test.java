package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class D11Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(String input, String expected) {
        Assertions.assertEquals(expected, D11.solutionPartOne(input));
    }

    @Test
    void testSolutionPartTwo() {
        // Puzzle 2
        Assertions.assertEquals("hxcaabcc", D11.solutionPartTwo(FileUtils.readFileAsString("y2015/D11.txt")));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of("abcdefgh", "abcdffaa"),
                Arguments.of("ghijklmn", "ghjaabcc"),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsString("y2015/D11.txt"), "hxbxxyzz")
        );
    }
}
