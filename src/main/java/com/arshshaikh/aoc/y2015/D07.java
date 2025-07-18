package com.arshshaikh.aoc.y2015;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class D07 {
    static int solutionPartOne(List<String> instructions) {
        Map<String, Integer> wireValueMap = new HashMap<>();
        Map<String, String> signalMap = instructions.stream().map(inst -> inst.split(" -> "))
                .collect(Collectors.toMap(parts -> parts[1], parts -> parts[0]));


        return solution("a", signalMap, wireValueMap);
    }

    static int solutionPartTwo(List<String> instructions) {
        Map<String, Integer> wireValueMap = new HashMap<>();
        Map<String, String> signalMap = instructions.stream().map(inst -> inst.split(" -> "))
                .collect(Collectors.toMap(parts -> parts[1], parts -> parts[0]));
        signalMap.put("b", String.valueOf(solution("a", signalMap, wireValueMap)));
        wireValueMap.clear();

        return solution("a", signalMap, wireValueMap);
    }

    private static int solution(String wire, Map<String, String> signalMap, Map<String, Integer> wireValueMap) {
        if (wireValueMap.containsKey(wire)) {
            return wireValueMap.get(wire);
        }

        String signal = signalMap.get(wire);

        if (signal.matches("\\d+")) {
            int value = Integer.parseInt(signal);
            wireValueMap.put(wire, value);
            return value;
        }

        String[] expression = signal.split(" ");

        int value = switch (expression.length) {
            case 1 -> solution(expression[0], signalMap, wireValueMap);
            case 2 -> ~solution(expression[1], signalMap, wireValueMap);
            case 3 -> {
                int operand1 = expression[0].matches("\\d+") ? Integer.parseInt(expression[0]) : solution(expression[0], signalMap, wireValueMap);
                int operand2 = expression[2].matches("\\d+") ? Integer.parseInt(expression[2]) : solution(expression[2], signalMap, wireValueMap);
                yield switch (expression[1]) {
                    case "AND" -> operand1 & operand2;
                    case "OR" -> operand1 | operand2;
                    case "LSHIFT" -> operand1 << operand2;
                    case "RSHIFT" -> operand1 >> operand2;
                    default -> throw new IllegalArgumentException("Not a valid operation: " + expression[1]);
                };
            }
            default -> throw new IllegalArgumentException("Not a valid signal: " + signal);
        };

        wireValueMap.put(wire, value);
        return value;
    }
}
