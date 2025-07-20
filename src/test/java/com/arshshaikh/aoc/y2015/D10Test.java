package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class D10Test {

    @Test
    void testSolutionPartOne() {
        // Puzzle 1
        Assertions.assertEquals(360154, D10.solutionPartOne(FileUtils.readFileAsString("y2015/D10.txt")));
    }

    @Test
    void testSolutionPartTwo() {
        // Puzzle 2
        Assertions.assertEquals(5103798, D10.solutionPartTwo(FileUtils.readFileAsString("y2015/D10.txt")));
    }
}
