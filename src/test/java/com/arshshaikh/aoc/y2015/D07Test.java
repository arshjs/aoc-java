package com.arshshaikh.aoc.y2015;

import com.arshshaikh.aoc.utils.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class D07Test {

    @Test
    void testSolutionPartOne() {
        // Puzzle 1
        Assertions.assertEquals(46065, D07.solutionPartOne(FileUtils.readFileAsList("y2015/D07.txt")));
    }

    @Test
    void testSolutionPartTwo() {
        // Puzzle 2
        Assertions.assertEquals(14134, D07.solutionPartTwo(FileUtils.readFileAsList("y2015/D07.txt")));
    }
}
