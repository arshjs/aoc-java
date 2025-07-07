package com.arshshaikh.aoc.y2015;

import java.util.List;

public class D02 {
    static int solutionPartOne(List<String> dimensions) {
        return dimensions.stream().map(dimension -> {
            int length = Integer.parseInt(dimension.substring(0, dimension.indexOf('x')));
            int width = Integer.parseInt(dimension.substring(dimension.indexOf('x') + 1, dimension.lastIndexOf('x')));
            int height = Integer.parseInt(dimension.substring(dimension.lastIndexOf('x') + 1));

            int lw = length * width;
            int wh = width * height;
            int lh = length * height;

            return 2 * (lw + wh + lh) + Math.min(lw, Math.min(wh, lh));
        }).reduce(0, Integer::sum);
    }

    static int solutionPartTwo(List<String> dimensions) {
        return dimensions.stream().map(dimension -> {
            int length = Integer.parseInt(dimension.substring(0, dimension.indexOf('x')));
            int width = Integer.parseInt(dimension.substring(dimension.indexOf('x') + 1, dimension.lastIndexOf('x')));
            int height = Integer.parseInt(dimension.substring(dimension.lastIndexOf('x') + 1));

            int lw = length + width;
            int wh = width + height;
            int lh = length + height;

            return length * width * height + 2 * Math.min(lw, Math.min(wh, lh));
        }).reduce(0, Integer::sum);
    }
}
