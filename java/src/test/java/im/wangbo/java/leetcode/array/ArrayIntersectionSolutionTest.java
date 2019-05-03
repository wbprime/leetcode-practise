package im.wangbo.java.leetcode.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class ArrayIntersectionSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr1, final int[] arr2, final int[] expected) {
        final ArrayIntersectionSolution s = new ArrayIntersectionSolution();

        final int[] result = s.intersect(arr1, arr2);

        Assertions.assertThat(result).containsExactlyInAnyOrder(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2}),
                Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9})
        );
    }
}