package com.arshshaikh.aoc.y2015;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D14 {
    static int solutionPartOne(List<String> details, int distance) {
        final Pattern pattern = Pattern.compile("\\w+ can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds.");

        List<Reindeer> reindeer = details.stream()
                .map(pattern::matcher)
                .filter(Matcher::find)
                .map(m -> new Reindeer(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3))))
                .toList();

        return reindeer.stream()
                .map(r -> (distance / r.cycleDuration() * r.flightDuration() + Math.min(distance % r.cycleDuration(), r.flightDuration)) * r.flightSpeed())
                .max(Integer::compareTo)
                .orElse(0);
    }

    static int solutionPartTwo(List<String> details, int distance) {
        final Pattern pattern = Pattern.compile("\\w+ can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds.");

        List<ReindeerStats> reindeer = details.stream()
                .map(pattern::matcher)
                .filter(Matcher::find)
                .map(m -> new ReindeerStats(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3))))
                .toList();

        int maxDistance = Integer.MIN_VALUE;
        for (int i = 1; i <= distance; i++) {
            for (ReindeerStats rs : reindeer) {
                if (i <= rs.getCycleDuration() * rs.getCycle() + rs.getFlightDuration()) {
                    rs.incrementDistance();
                    maxDistance = Math.max(maxDistance, rs.getDistance());
                }

                if (i % rs.getCycleDuration() == 0) {
                    rs.incrementCycle();
                }
            }

            for (ReindeerStats rs : reindeer) {
                if (maxDistance == rs.getDistance()) {
                    rs.incrementScore();
                }
            }
        }

        return reindeer.stream().map(ReindeerStats::getScore).max(Integer::compareTo).orElse(0);
    }

    private record Reindeer(int flightSpeed, int flightDuration, int restDuration) {
        int cycleDuration() {
            return flightDuration + restDuration;
        }
    }

    private static class ReindeerStats {
        private final int flightSpeed;
        private final int flightDuration;
        private final int restDuration;
        private int cycle;
        private int distance;
        private int score;

        private ReindeerStats(int flightSpeed, int flightDuration, int restDuration) {
            this.flightSpeed = flightSpeed;
            this.flightDuration = flightDuration;
            this.restDuration = restDuration;
        }

        public int getFlightDuration() {
            return flightDuration;
        }

        public int getCycle() {
            return cycle;
        }

        public void incrementCycle() {
            cycle++;
        }

        public int getCycleDuration() {
            return flightDuration + restDuration;
        }

        public int getDistance() {
            return distance;
        }

        public void incrementDistance() {
            distance += flightSpeed;
        }

        public int getScore() {
            return score;
        }

        public void incrementScore() {
            score++;
        }
    }
}
