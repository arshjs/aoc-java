package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class D09Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(List<String> input, int expected) {
        Assertions.assertEquals(expected, D09.solutionPartOne(input));
    }

    @ParameterizedTest
    @MethodSource("casesPartTwo")
    void testSolutionPartTwo(List<String> input, int expected) {
        Assertions.assertEquals(expected, D09.solutionPartTwo(input));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of(List.of("London to Dublin = 464", "London to Belfast = 518", "Dublin to Belfast = 141"), 605),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsList("y2015/D09.txt"), 141)
        );
    }

    private static Stream<Arguments> casesPartTwo() {
        return Stream.of(
                Arguments.of(List.of("London to Dublin = 464", "London to Belfast = 518", "Dublin to Belfast = 141"), 982),

                // Puzzle 2
                Arguments.of(FileUtils.readFileAsList("y2015/D09.txt"), 736)
        );
    }
}
