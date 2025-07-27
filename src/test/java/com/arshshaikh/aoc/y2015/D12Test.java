package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class D12Test {

    @ParameterizedTest
    @MethodSource("casesPartOne")
    void testSolutionPartOne(String input, int expected) {
        Assertions.assertEquals(expected, D12.solutionPartOne(input));
    }

    @ParameterizedTest
    @MethodSource("casesPartTwo")
    void testSolutionPartTwo(String input, int expected) {
        Assertions.assertEquals(expected, D12.solutionPartTwo(input));
    }

    private static Stream<Arguments> casesPartOne() {
        return Stream.of(
                Arguments.of("[1,2,3]", 6),
                Arguments.of("{\"a\":2,\"b\":4}", 6),
                Arguments.of("[[[3]]]", 3),
                Arguments.of("{\"a\":{\"b\":4},\"c\":-1}", 3),
                Arguments.of("{\"a\":[-1,1]}", 0),
                Arguments.of("[-1,{\"a\":1}]", 0),
                Arguments.of("[]", 0),
                Arguments.of("{}", 0),

                // Puzzle 1
                Arguments.of(FileUtils.readFileAsString("y2015/D12.txt"), 111754)
        );
    }

    private static Stream<Arguments> casesPartTwo() {
        return Stream.of(
                Arguments.of("[1,2,3]", 6),
                Arguments.of("[1,{\"c\":\"red\",\"b\":2},3]", 4),
                Arguments.of("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}", 0),
                Arguments.of("[1,\"red\",5]", 6),

                // Puzzle 2
                Arguments.of(FileUtils.readFileAsString("y2015/D12.txt"), 65402)
        );
    }
}
