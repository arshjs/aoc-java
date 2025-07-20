package com.arshshaikh.aoc.y2015;

import java.util.*;

public class D09 {
    private static final String route = "%s-%s";

    static int solutionPartOne(List<String> itinerary) {
        Map<String, Integer> distance = new HashMap<>();
        Set<String> cities = new HashSet<>();

        itinerary.forEach(it -> {
            String[] str = it.split(" ");
            distance.put(route.formatted(str[0], str[2]), Integer.parseInt(str[4]));
            distance.put(route.formatted(str[2], str[0]), Integer.parseInt(str[4]));
            cities.add(str[0]);
            cities.add(str[2]);
        });

        return cities.stream().map(city -> {
            Set<String> visited = new HashSet<>();
            visited.add(city);
            return computeShortestDistance(distance, cities, visited, city, 0);
        }).reduce(Integer.MAX_VALUE, Integer::min);
    }

    static int solutionPartTwo(List<String> itinerary) {
        Map<String, Integer> distance = new HashMap<>();
        Set<String> cities = new HashSet<>();

        itinerary.forEach(it -> {
            String[] str = it.split(" ");
            distance.put(route.formatted(str[0], str[2]), Integer.parseInt(str[4]));
            distance.put(route.formatted(str[2], str[0]), Integer.parseInt(str[4]));
            cities.add(str[0]);
            cities.add(str[2]);
        });

        return cities.stream().map(city -> {
            Set<String> visited = new HashSet<>();
            visited.add(city);
            return computeLongestDistance(distance, cities, visited, city, 0);
        }).reduce(Integer.MIN_VALUE, Integer::max);
    }

    private static int computeShortestDistance(Map<String, Integer> distance, Set<String> cities, Set<String> visited, String currentCity, int totalDistance) {
        if (visited.size() == cities.size()) {
            return totalDistance;
        }

        String minDistanceCity = null;
        int minDistance = Integer.MAX_VALUE;
        for (String city : cities) {
            if (visited.contains(city)) {
                continue;
            }

            int dist = distance.get(route.formatted(currentCity, city));
            if (minDistance > dist) {
                minDistance = dist;
                minDistanceCity = city;
            }
        }
        visited.add(minDistanceCity);
        return computeShortestDistance(distance, cities, visited, minDistanceCity, totalDistance + minDistance);
    }

    private static int computeLongestDistance(Map<String, Integer> distance, Set<String> cities, Set<String> visited, String currentCity, int totalDistance) {
        if (visited.size() == cities.size()) {
            return totalDistance;
        }

        String maxDistanceCity = null;
        int maxDistance = Integer.MIN_VALUE;
        for (String city : cities) {
            if (visited.contains(city)) {
                continue;
            }

            int dist = distance.get(route.formatted(currentCity, city));
            if (maxDistance < dist) {
                maxDistance = dist;
                maxDistanceCity = city;
            }
        }
        visited.add(maxDistanceCity);
        return computeLongestDistance(distance, cities, visited, maxDistanceCity, totalDistance + maxDistance);
    }
}
