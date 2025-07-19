package com.arshshaikh.aoc.y2015;

import java.util.List;

public class D08 {
    static int solutionPartOne(List<String> strings) {
        return strings.stream().map(str -> {
            int literalCount = 2;
            int memoryCount = 0;

            for (int i = 1; i < str.length() - 1; i++, memoryCount++, literalCount++) {
                char currentChar = str.charAt(i);

                if (currentChar == '\\') {
                    if (str.charAt(i + 1) == 'x') {
                        i += 3;
                        literalCount += 3;
                    } else {
                        i++;
                        literalCount++;
                    }
                }
            }

            return literalCount - memoryCount;
        }).reduce(0, Integer::sum);
    }

    static int solutionPartTwo(List<String> strings) {
        return strings.stream().map(str -> {
            int literalCount = 0;
            int encodedCount = 2;

            for (int i = 0; i < str.length(); i++, encodedCount++, literalCount++) {
                char currentChar = str.charAt(i);

                if (currentChar == '\\' || currentChar == '\"') {
                    encodedCount++;
                }
            }

            return encodedCount - literalCount;
        }).reduce(0, Integer::sum);
    }
}
