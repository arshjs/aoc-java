package com.arshshaikh.aoc.y2015;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class D03 {
    static int solutionPartOne(String instructions) {
        int[] santaCoordinates = {0, 0};

        Set<String> visitedHouses = new HashSet<>();
        visitedHouses.add(santaCoordinates[0] + "," + santaCoordinates[1]);

        instructions.chars().forEachOrdered(ch -> {
            moveSanta(santaCoordinates, (char) ch);
            visitedHouses.add(santaCoordinates[0] + "," + santaCoordinates[1]);
        });

        return visitedHouses.size();
    }

    static int solutionPartTwo(String instructions) {
        int[] santaCoordinates = {0, 0};
        int[] roboSantaCoordinates = {0, 0};

        Set<String> visitedHouses = new HashSet<>();
        visitedHouses.add(santaCoordinates[0] + "," + santaCoordinates[1]);

        IntStream.range(0, instructions.length()).forEachOrdered(i -> {
            if (i % 2 == 0) {
                moveSanta(santaCoordinates, instructions.charAt(i));
                visitedHouses.add(santaCoordinates[0] + "," + santaCoordinates[1]);
            } else {
                moveSanta(roboSantaCoordinates, instructions.charAt(i));
                visitedHouses.add(roboSantaCoordinates[0] + "," + roboSantaCoordinates[1]);
            }
        });

        return visitedHouses.size();
    }

    private static void moveSanta(int[] santaCoordinates, char direction) {
        switch (direction) {
            case '>':
                santaCoordinates[0]++;
                break;
            case '<':
                santaCoordinates[0]--;
                break;
            case '^':
                santaCoordinates[1]++;
                break;
            case 'v':
                santaCoordinates[1]--;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }
}
