package com.arshshaikh.aoc.y2015;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.IntStream;

public class D04 {
    static int solutionPartOne(String secret) {
        return solution(secret, 5);
    }

    static int solutionPartTwo(String secret) {
        return solution(secret, 6);
    }

    private static int solution(String secret, int prefixedZeros) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        final int prefixedBytes = prefixedZeros / 2;
        final boolean hasZeroNibble = prefixedZeros % 2 != 0;

        return IntStream.iterate(1, i -> i + 1)
                .filter(i -> {
                    byte[] hash = md.digest((secret + i).getBytes());

                    for (int j = 0; j < prefixedBytes; j++) {
                        if (hash[j] != 0) {
                            return false;
                        }
                    }

                    return !hasZeroNibble || (hash[prefixedBytes] & 0xF0) == 0;
                }).findFirst().orElse(0);
    }
}
