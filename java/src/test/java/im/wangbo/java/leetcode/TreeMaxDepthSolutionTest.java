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
class TreeMaxDepthSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final TreeMaxDepthSolution.TreeNode root, final int expected) {
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

    static TreeMaxDepthSolution.TreeNode create2() {
        TreeMaxDepthSolution.TreeNode root = new TreeMaxDepthSolution.TreeNode(3);
        return root;
    }

    static TreeMaxDepthSolution.TreeNode create1() {
        TreeMaxDepthSolution.TreeNode root = new TreeMaxDepthSolution.TreeNode(3);

        root.left = new TreeMaxDepthSolution.TreeNode(9);

        root.right = new TreeMaxDepthSolution.TreeNode(20);

        root.right.left = new TreeMaxDepthSolution.TreeNode(15);
        root.right.right = new TreeMaxDepthSolution.TreeNode(7);

        return root;
    }
}