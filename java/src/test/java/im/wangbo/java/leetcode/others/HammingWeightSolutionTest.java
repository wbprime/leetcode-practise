package im.wangbo.java.leetcode.others;

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
class HammingWeightSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int a, final int expected) {
        final HammingWeightSolution s = new HammingWeightSolution();

        final int result = s.hammingWeight(a);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(-3, 31), // 0b11111111111111111111111111111101
                Arguments.of(128, 1), // 0b00000000000000000000000010000000
                Arguments.of(11, 3) // 0b00000000000000000000000000001011
        );
    }
}