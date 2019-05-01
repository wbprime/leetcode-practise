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
class SimplifyPathSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final String str, final String expected) {
        final SimplifyPathSolution s = new SimplifyPathSolution();
        final String result = s.simplifyPath(str);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("/home/", "/home"),
                Arguments.of("/../", "/"),
                Arguments.of("/home//foo/", "/home/foo"),
                Arguments.of("/a/./b/../../c/", "/c"),
                Arguments.of("/a/../../b/../c//.//", "/c"),
                Arguments.of("/a//b////c/d//././/..", "/a/b/c")
        );
    }
}