package im.wangbo.java.leetcode.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class GroupAnagramsSolutionTest {
    @Test
    void test() {
        final GroupAnagramsSolution s = new GroupAnagramsSolution();

        final String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        final List<List<String>> result = s.groupAnagrams(arr);

        Assertions.assertThat(result).hasSize(3);
        assertList(result.get(0));
        assertList(result.get(1));
        assertList(result.get(2));
    }

    private void assertList(final List<String> list) {
        if (list.size() == 1) {
            Assertions.assertThat(list).containsExactlyInAnyOrder("bat");
        } else if (list.size() == 2) {
            Assertions.assertThat(list).containsExactlyInAnyOrder("nat", "tan");
        } else if (list.size() == 3) {
            Assertions.assertThat(list).containsExactlyInAnyOrder("ate", "eat", "tea");
        } else {
            Assertions.fail("Should not return such list");
        }
    }
}