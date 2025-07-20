package com.arshshaikh.aoc.y2015;

public class D10 {
    static int solutionPartOne(String sequence) {
        return solution(sequence, 40, 0).length();
    }

    static int solutionPartTwo(String sequence) {
        return solution(sequence, 50, 0).length();
    }

    private static String solution(String sequence, int maxTimes, int times) {
        if (times == maxTimes) {
            return sequence;
        }

        int count = 1;

        StringBuilder nextSequence = new StringBuilder();
        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i - 1) != sequence.charAt(i)) {
                nextSequence.append(count).append(sequence.charAt(i - 1));
                count = 0;
            }

            count++;
        }

        nextSequence.append(count).append(sequence.charAt(sequence.length() - 1));
        return solution(nextSequence.toString(), maxTimes, times + 1);
    }
}
