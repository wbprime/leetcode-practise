package im.wangbo.java.leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class RestoreInAddressSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final String str, final String[] expected) {
        final RestoreInAddressSolution s = new RestoreInAddressSolution();
        final List<String> result = s.restoreIpAddresses(str);

        Assertions.assertThat(result).containsExactlyInAnyOrder(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("25525511135", new String[]{"255.255.11.135", "255.255.111.35"})
        );
    }

}