package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class D16Test {

    @Test
    void testSolutionPartOne() {
        // Puzzle 1
        Assertions.assertEquals(373, D16.solutionPartOne(FileUtils.readFileAsList("y2015/D16.txt")));
    }

    @Test
    void testSolutionPartTwo() {
        // Puzzle 2
        Assertions.assertEquals(260, D16.solutionPartTwo(FileUtils.readFileAsList("y2015/D16.txt")));
    }
}
