package com.arshshaikh.aoc.y2015;

public class D01 {
    public static int solution(String instructions) {
        final int up = '(';
        return instructions.chars().map(f -> f == up ? 1 : -1).reduce(0, Integer::sum);
    }
}
