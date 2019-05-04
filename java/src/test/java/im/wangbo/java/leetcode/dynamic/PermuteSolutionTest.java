package im.wangbo.java.leetcode.dynamic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class PermuteSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final List<List<Integer>> expected) {
        final PermuteSolution s = new PermuteSolution();

        final List<List<Integer>> result = s.permute2(arr);

        Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                create1(), create2(), create3()
        );
    }

    static Arguments create1() {
        final int[] arr = {1, 2, 3};

        final List<List<Integer>> list = new ArrayList<>();
        {
            final List<Integer> l = new ArrayList<>();
            l.add(1);
            l.add(2);
            l.add(3);
            list.add(l);
        }
        {
            final List<Integer> l = new ArrayList<>();
            l.add(1);
            l.add(3);
            l.add(2);
            list.add(l);
        }
        {
            final List<Integer> l = new ArrayList<>();
            l.add(2);
            l.add(1);
            l.add(3);
            list.add(l);
        }
        {
            final List<Integer> l = new ArrayList<>();
            l.add(2);
            l.add(3);
            l.add(1);
            list.add(l);
        }
        {
            final List<Integer> l = new ArrayList<>();
            l.add(3);
            l.add(1);
            l.add(2);
            list.add(l);
        }
        {
            final List<Integer> l = new ArrayList<>();
            l.add(3);
            l.add(2);
            l.add(1);
            list.add(l);
        }
        return Arguments.of(arr, list);
    }

    static Arguments create2() {
        final int[] arr = {1, 2};

        final List<List<Integer>> list = new ArrayList<>();
        {
            final List<Integer> l = new ArrayList<>();
            l.add(1);
            l.add(2);
            list.add(l);
        }
        {
            final List<Integer> l = new ArrayList<>();
            l.add(2);
            l.add(1);
            list.add(l);
        }
        return Arguments.of(arr, list);
    }

    static Arguments create3() {
        final int[] arr = {1};

        final List<List<Integer>> list = new ArrayList<>();
        {
            final List<Integer> l = new ArrayList<>();
            l.add(1);
            list.add(l);
        }
        return Arguments.of(arr, list);
    }
}