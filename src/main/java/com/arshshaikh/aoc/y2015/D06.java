package com.arshshaikh.aoc.y2015;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D06 {
    static int solutionPartOne(List<String> instructions) {
        boolean[][] lights = new boolean[1000][1000];

        final Pattern pattern = Pattern.compile("(turn on|turn off|toggle) (\\d{1,3}),(\\d{1,3}) through (\\d{1,3}),(\\d{1,3})");

        instructions.forEach(instruction -> {
            Matcher matcher = pattern.matcher(instruction);

            if (!matcher.find()) {
                return;
            }

            Function<Boolean, Boolean> operator = switch (matcher.group(1)) {
                case "turn on" -> _ -> true;
                case "turn off" -> _ -> false;
                case "toggle" -> b -> !b;
                default -> throw new IllegalStateException("No such action defined: " + matcher.group(1));
            };

            int x1 = Integer.parseInt(matcher.group(2));
            int y1 = Integer.parseInt(matcher.group(3));
            int x2 = Integer.parseInt(matcher.group(4)) + 1;
            int y2 = Integer.parseInt(matcher.group(5)) + 1;

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
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

        final Pattern pattern = Pattern.compile("(turn on|turn off|toggle) (\\d{1,3}),(\\d{1,3}) through (\\d{1,3}),(\\d{1,3})");

        instructions.forEach(instruction -> {
            Matcher matcher = pattern.matcher(instruction);

            if (!matcher.find()) {
                return;
            }

            IntUnaryOperator operator = switch (matcher.group(1)) {
                case "turn on" -> i -> i + 1;
                case "turn off" -> i -> Math.max(i - 1, 0);
                case "toggle" -> i -> i + 2;
                default -> throw new IllegalStateException("No such action defined: " + matcher.group(1));
            };

            int x1 = Integer.parseInt(matcher.group(2));
            int y1 = Integer.parseInt(matcher.group(3));
            int x2 = Integer.parseInt(matcher.group(4)) + 1;
            int y2 = Integer.parseInt(matcher.group(5)) + 1;

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    lights[i][j] = operator.applyAsInt(lights[i][j]);
                }
            }
        });

        return Arrays.stream(lights).flatMapToInt(Arrays::stream).reduce(0, Integer::sum);
    }
}
