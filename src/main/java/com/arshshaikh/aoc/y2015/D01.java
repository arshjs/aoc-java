package com.arshshaikh.aoc.y2015;

public class D01 {
    public static int solutionPartOne(String instructions) {
        final int up = '(';
        return instructions.chars().map(f -> f == up ? 1 : -1).reduce(0, Integer::sum);
    }

    public static int solutionPartTwo(String instructions) {
        int floor = 0;
        for (int i = 0; i < instructions.length(); i++) {
            floor += instructions.charAt(i) == '(' ? 1 : -1;

            if (floor == -1) {
                return i + 1;
            }
        }

        return 0;
    }
}
