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
class TreeIsValidBSTSolutionTest {
    @ParameterizedTest
    @MethodSource("arguments")
    void test(final TreeNode root, final boolean expected) {
        final TreeIsValidBSTSolution s = new TreeIsValidBSTSolution();

        final boolean result = s.isValidBST(root);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(create4(), false),
                Arguments.of(create3(), false),
                Arguments.of(create2(), true),
                Arguments.of(create1(), false)
        );
    }

    static TreeNode create4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        return root;
    }

    static TreeNode create3() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);

        root.right = new TreeNode(15);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        return root;
    }

    static TreeNode create2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        return root;
    }

    static TreeNode create1() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);

        root.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        return root;
    }
}