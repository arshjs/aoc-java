package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class D15Test {

    @Test
    void testSolutionPartOne() {
        // Puzzle 1
        Assertions.assertEquals(373, D15.solutionPartOne(FileUtils.readFileAsList("y2015/D15.txt")));
    }

    @Test
    void testSolutionPartTwo() {
        // Puzzle 2
        Assertions.assertEquals(260, D15.solutionPartTwo(FileUtils.readFileAsList("y2015/D15.txt")));
    }
}
