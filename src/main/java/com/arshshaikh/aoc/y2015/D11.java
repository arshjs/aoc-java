package com.arshshaikh.aoc.y2015;

public class D11 {
    static String solutionPartOne(String pwd) {
        return solution(pwd);
    }

    static String solutionPartTwo(String pwd) {
        return solution(solution(pwd));
    }

    private static String solution(String pwd) {
        char[] pwdChars = pwd.toCharArray();

        sanitizePwd(pwdChars);

        while (true) {
            createNewPwd(pwdChars);

            byte pairs = 0;
            boolean hasIncrementingChars = false;

            for (int i = 1; i < pwdChars.length - 1; i++) {
                char prevCh = pwdChars[i - 1];
                char currentCh = pwdChars[i];
                char nextCh = pwdChars[i + 1];

                if (currentCh + 1 == nextCh && prevCh + 1 == currentCh) {
                    hasIncrementingChars = true;
                    break;
                }
            }

            for (int i = 0; i < pwdChars.length - 1; i++) {
                if (pwdChars[i] == pwdChars[i + 1]) {
                    pairs++;
                    i++;
                }
            }

            if (hasIncrementingChars && pairs > 1) {
                break;
            }
        }

        return String.valueOf(pwdChars);
    }

    private static void sanitizePwd(char[] pwd) {
        int i = 0;

        while (i < pwd.length) {
            if (pwd[i] == 'i' || pwd[i] == 'o' || pwd[i] == 'l') {
                pwd[i]++;
                break;
            }
            i++;
        }

        for (int j = i + 1; j < pwd.length; j++) {
            pwd[j] = 'a';
        }
    }

    private static void createNewPwd(char[] pwd) {
        for (int i = pwd.length - 1; i >= 0; i--) {
            if (pwd[i] == 'z') {
                pwd[i] = 'a';
                continue;
            }

            if (pwd[i] == 'i' || pwd[i] == 'o' || pwd[i] == 'l') {
                pwd[i]++;
            }

            pwd[i]++;
            break;
        }
    }
}
