package com.arshshaikh.aoc.y2015;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class D12 {
    static int solutionPartOne(String data) {
        return Pattern.compile("-?\\d+")
                .matcher(data)
                .results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    static int solutionPartTwo(String data) {
        try {
            return sumWithoutRed(new ObjectMapper().readTree(data));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing json.", e);
        }
    }

    private static int sumWithoutRed(JsonNode node) {
        if (node.isNumber()) {
            return node.asInt();
        }

        if (node.isArray()) {
            return node.valueStream().map(D12::sumWithoutRed).reduce(0, Integer::sum);
        }

        if (node.isObject()) {
            if (node.valueStream().filter(JsonNode::isTextual).map(JsonNode::asText).anyMatch("red"::equals)) {
                return 0;
            }

            return node.valueStream().map(D12::sumWithoutRed).reduce(0, Integer::sum);
        }

        return 0;
    }
}
