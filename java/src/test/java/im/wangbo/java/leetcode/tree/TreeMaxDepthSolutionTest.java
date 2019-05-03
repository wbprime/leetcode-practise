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
class TreeMaxDepthSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final TreeNode root, final int expected) {
        final TreeMaxDepthSolution s = new TreeMaxDepthSolution();

        final int result = s.maxDepth(root);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(create2(), 1),
                Arguments.of(create1(), 3)
        );
    }

    static TreeNode create2() {
        TreeNode root = new TreeNode(3);
        return root;
    }

    static TreeNode create1() {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return root;
    }
}