package com.arshshaikh.aoc.y2015;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class D06 {
    static int solutionPartOne(List<String> instructions) {
        boolean[][] lights = new boolean[1000][1000];

        final Pattern pattern = Pattern.compile("\\d{1,3}");

        instructions.forEach(instruction -> {
            int[] coordinates = pattern.matcher(instruction).results().map(MatchResult::group).mapToInt(Integer::parseInt).toArray();

            Function<Boolean, Boolean> operator;
            if (instruction.startsWith("turn on")) {
                operator = _ -> true;
            } else if (instruction.startsWith("turn off")) {
                operator = _ -> false;
            } else if (instruction.startsWith("toggle")) {
                operator = b -> !b;
            } else {
                throw new IllegalArgumentException("No such action defined.");
            }

            for (int i = coordinates[0]; i <= coordinates[2]; i++) {
                for (int j = coordinates[1]; j <= coordinates[3]; j++) {
                    lights[i][j] = operator.apply(lights[i][j]);
                }
            }
        });

        int count = 0;
        for (boolean[] light : lights) {
            for (boolean l : light) {
                count += l ? 1 : 0;
            }
        }

        return count;
    }

    static int solutionPartTwo(List<String> instructions) {
        int[][] lights = new int[1000][1000];

        final Pattern pattern = Pattern.compile("\\d{1,3}");

        instructions.forEach(instruction -> {
            int[] coordinates = pattern.matcher(instruction).results().map(MatchResult::group).mapToInt(Integer::parseInt).toArray();

            IntUnaryOperator operator;
            if (instruction.startsWith("turn on")) {
                operator = i -> i + 1;
            } else if (instruction.startsWith("turn off")) {
                operator = i -> Math.max(i - 1, 0);
            } else if (instruction.startsWith("toggle")) {
                operator = i -> i + 2;
            } else {
                throw new IllegalArgumentException("No such action defined.");
            }

            for (int i = coordinates[0]; i <= coordinates[2]; i++) {
                for (int j = coordinates[1]; j <= coordinates[3]; j++) {
                    lights[i][j] = operator.applyAsInt(lights[i][j]);
                }
            }
        });

        return Arrays.stream(lights).flatMapToInt(Arrays::stream).reduce(0, Integer::sum);
    }
}
