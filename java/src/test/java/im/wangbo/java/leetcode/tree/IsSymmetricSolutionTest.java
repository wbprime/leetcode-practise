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
class IsSymmetricSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final TreeNode root, final boolean expected) {
        final IsSymmetricSolution s = new IsSymmetricSolution();

        final boolean result = s.isSymmetric(root);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(create3(), false),
                Arguments.of(create2(), true),
                Arguments.of(create1(), true)
        );
    }

    static TreeNode create2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        return root;
    }

    static TreeNode create3() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        return root;
    }

    static TreeNode create1() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        return root;
    }
}