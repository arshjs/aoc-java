package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class D05Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(List<String> input, int expected) {
        Assertions.assertEquals(expected, D05.solutionPartOne(input));
    }

    @ParameterizedTest
    @MethodSource("casesPartTwo")
    void testSolutionPartTwo(List<String> input, int expected) {
        Assertions.assertEquals(expected, D05.solutionPartTwo(input));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of(List.of("ugknbfddgicrmopn"), 1),
                Arguments.of(List.of("aaa"), 1),
                Arguments.of(List.of("jchzalrnumimnmhp"), 0),
                Arguments.of(List.of("haegwjzuvuyypxyu"), 0),
                Arguments.of(List.of("dvszwmarrgswjxmb"), 0),
                Arguments.of(List.of("ugknbfddgicrmopn", "aaa", "jchzalrnumimnmhp", "haegwjzuvuyypxyu", "dvszwmarrgswjxmb"), 2),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsList("y2015/D05.txt"), 258)
        );
    }

    private static Stream<Arguments> casesPartTwo() {
        return Stream.of(
                Arguments.of(List.of("qjhvhtzxzqqjkmpb"), 1),
                Arguments.of(List.of("xxyxx"), 1),
                Arguments.of(List.of("aaa"), 0),
                Arguments.of(List.of("eieaaabghaa"), 1),
                Arguments.of(List.of("uurcxstgmygtbstg"), 0),
                Arguments.of(List.of("ieodomkazucvgmuy"), 0),
                Arguments.of(List.of("qjhvhtzxzqqjkmpb", "xxyxx", "uurcxstgmygtbstg", "ieodomkazucvgmuy"), 2),

                // Puzzle 2
                Arguments.of(FileUtils.readFileAsList("y2015/D05.txt"), 53)
        );
    }
}
