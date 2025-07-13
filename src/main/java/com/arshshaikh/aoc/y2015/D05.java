package com.arshshaikh.aoc.y2015;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D05 {

    static int solutionPartOne(List<String> strings) {
        return (int) strings.stream().filter(D05::isNicePartOne).count();
    }

    static int solutionPartTwo(List<String> strings) {
        return (int) strings.stream().filter(D05::isNicePartTwo).count();
    }

    private static boolean isNicePartOne(String str) {
        if (str.length() < 3) {
            return false;
        }

        int vowelCount = isVowel(str.charAt(0)) ? 1 : 0;
        boolean hasRepeatingLetter = false;

        for (int i = 1; i < str.length(); i++) {
            char previousCh = str.charAt(i - 1);
            char currentCh = str.charAt(i);
            if (isBannedSubstring(previousCh, currentCh)) {
                return false;
            }

            if (previousCh == currentCh) {
                hasRepeatingLetter = true;
            }

            if (isVowel(currentCh)) {
                vowelCount++;
            }
        }

        return hasRepeatingLetter && vowelCount > 2;
    }

    private static boolean isNicePartTwo(String str) {
        if (str.length() < 3) {
            return false;
        }

        boolean hasRepeatingLetter = false;

        for (int i = 2; i < str.length(); i++) {
            if (str.charAt(i - 2) == str.charAt(i)) {
                hasRepeatingLetter = true;
                break;
            }
        }

        if (!hasRepeatingLetter) {
            return false;
        }

        Map<String, Integer> pairs = new HashMap<>();

        for (int i = 1; i < str.length(); i++) {
            String pair = str.substring(i - 1, i + 1);

            if (pairs.containsKey(pair) && pairs.get(pair) < i - 1) {
                return true;
            }

            if (!pairs.containsKey(pair)) {
                pairs.put(pair, i);
            }
        }

        return false;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static boolean isBannedSubstring(char ch1, char ch2) {
        return (ch1 == 'a' && ch2 == 'b') || (ch1 == 'c' && ch2 == 'd') || (ch1 == 'p' && ch2 == 'q') || (ch1 == 'x' && ch2 == 'y');
    }
}
