package im.wangbo.java.leetcode;

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
class RemoveDuplicatesSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int[] arr, final int expected) {
        final RemoveDuplicatesSolution s = new RemoveDuplicatesSolution();
        final int result = s.removeDuplicates(arr);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, 2),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5)
        );
    }
}