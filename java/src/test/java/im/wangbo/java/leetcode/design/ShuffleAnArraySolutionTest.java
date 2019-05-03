package im.wangbo.java.leetcode.design;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class ShuffleAnArraySolutionTest {
    @Test
    void test() {
        final Random r = new Random();

        final int[] arr = new int[r.nextInt(10) + 10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2 + 1;
        }

        final ShuffleAnArraySolution s = new ShuffleAnArraySolution(arr);

        final Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length * 10; i++) {
            final int[] result = s.shuffle();
            final String str = String.join(",", Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.toList()));
            map.putIfAbsent(str, 0);
            map.computeIfPresent(str, (k, n) -> n + 1);
        }

        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }

}