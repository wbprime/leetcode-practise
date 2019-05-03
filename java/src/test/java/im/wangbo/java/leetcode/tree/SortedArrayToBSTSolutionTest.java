package im.wangbo.java.leetcode.tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class SortedArrayToBSTSolutionTest {
    @Test
    void test() {
        final SortedArrayToBSTSolution s = new SortedArrayToBSTSolution();

        final int[] arr = new int[]{-10, -3, 0, 5, 9};
        final int[] expected = Arrays.copyOf(arr, arr.length);
        final TreeNode result = s.sortedArrayToBST(arr);

        final int[] collected = new int[arr.length];
        for (int i = 0; i < collected.length; i++) {
            collected[i] = Integer.MIN_VALUE;
        }

        final InorderTraversal traversal = new InorderTraversal();
        traversal.traverse(result, new TraversalConsumer() {
            int idx = 0;
            @Override
            public void apply(TreeNode node) {
                collected[idx++] = node.val;
            }
        });

        Assertions.assertThat(collected).isEqualTo(expected);
    }
}