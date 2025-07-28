package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class D14Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(List<String> inputDetails, int inputDistance, int expected) {
        Assertions.assertEquals(expected, D14.solutionPartOne(inputDetails, inputDistance));
    }

    @ParameterizedTest
    @MethodSource("casesPartTwo")
    void testSolutionPartTwo(List<String> inputDetails, int inputDistance, int expected) {
        Assertions.assertEquals(expected, D14.solutionPartTwo(inputDetails, inputDistance));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of(List.of("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."), 1000, 1120),
                Arguments.of(List.of("Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds."), 1000, 1056),
                Arguments.of(List.of("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.", "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds."), 1000, 1120),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsList("y2015/D14.txt"), 2503, 2696)
        );
    }

    private static Stream<Arguments> casesPartTwo() {
        return Stream.of(
                Arguments.of(List.of("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."), 1000, 1000),
                Arguments.of(List.of("Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds."), 1000, 1000),
                Arguments.of(List.of("Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.", "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds."), 1000, 689),

                // Puzzle 2
                Arguments.of(FileUtils.readFileAsList("y2015/D14.txt"), 2503, 1084)
        );
    }
}
