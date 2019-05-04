package im.wangbo.java.leetcode.tree;

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
class NumIslandsSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final char[][] grid, final int expected) {
        final NumIslandsSolution s = new NumIslandsSolution();

        final int result = s.numIslands(grid);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(create1(), create2(), create3());
    }

    static Arguments create1() {
        return Arguments.of(
                new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                },
                3
        );
    }

    static Arguments create2() {
        return Arguments.of(
                new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                },
                1
        );
    }

    static Arguments create3() {
        return Arguments.of(
                new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                },
                1
        );
    }
}