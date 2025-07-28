package com.arshshaikh.aoc.y2015;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D16 {
    static int solutionPartOne(List<String> details) {
        final Pattern pattern = Pattern.compile("Sue (\\d+): (\\w+): (\\d+), (\\w+): (\\d+), (\\w+): (\\d+)");

        final Map<String, Integer> sue = Map.of("children", 3, "cats", 7, "samoyeds", 2,
                "pomeranians", 3, "akitas", 0, "vizslas", 0, "goldfish", 5,
                "trees", 3, "cars", 2, "perfumes", 1);

        return details.stream()
                .map(pattern::matcher)
                .filter(Matcher::find)
                .filter(m -> sue.get(m.group(2)) == Integer.parseInt(m.group(3)))
                .filter(m -> sue.get(m.group(4)) == Integer.parseInt(m.group(5)))
                .filter(m -> sue.get(m.group(6)) == Integer.parseInt(m.group(7)))
                .map(m -> Integer.parseInt(m.group(1)))
                .findFirst()
                .orElse(0);
    }

    static int solutionPartTwo(List<String> details) {
        final Pattern pattern = Pattern.compile("Sue (\\d+): (\\w+): (\\d+), (\\w+): (\\d+), (\\w+): (\\d+)");

        final Map<String, Integer> sue = Map.of("children", 3, "cats", 7, "samoyeds", 2,
                "pomeranians", 3, "akitas", 0, "vizslas", 0, "goldfish", 5,
                "trees", 3, "cars", 2, "perfumes", 1);

        return details.stream()
                .map(pattern::matcher)
                .filter(Matcher::find)
                .filter(m -> isValidMatch(sue, m.group(2), m.group(3)))
                .filter(m -> isValidMatch(sue, m.group(4), m.group(5)))
                .filter(m -> isValidMatch(sue, m.group(6), m.group(7)))
                .map(m -> Integer.parseInt(m.group(1)))
                .findFirst()
                .orElse(0);
    }

    private static boolean isValidMatch(Map<String, Integer> sue, String compound, String value) {
        int count = Integer.parseInt(value);

        if ("cars".equals(compound) || "trees".equals(compound)) {
            return count > sue.get(compound);
        } else if ("pomeranians".equals(compound) || "goldfish".equals(compound)) {
            return count < sue.get(compound);
        } else {
            return count == sue.get(compound);
        }
    }

}
