package im.wangbo.java.leetcode.tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class LevelOrderSolutionTest {
    @Test
    void test() {
        final LevelOrderSolution s = new LevelOrderSolution();

        final List<List<Integer>> result = s.levelOrder(create1());

        Assertions.assertThat(result).isEqualTo(list1());
    }

    static List<List<Integer>> list1() {
        final List<List<Integer>> result = new ArrayList<>(3);

        {
            final List<Integer> l = new ArrayList<>(1);
            l.add(5);
            result.add(l);
        }
        {
            final List<Integer> l = new ArrayList<>(2);
            l.add(1);
            l.add(4);
            result.add(l);
        }
        {
            final List<Integer> l = new ArrayList<>(2);
            l.add(3);
            l.add(6);
            result.add(l);
        }

        return result;
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