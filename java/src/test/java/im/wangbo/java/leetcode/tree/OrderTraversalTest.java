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
class OrderTraversalTest {
    @Test
    void preorder() {
        final PreorderTraversal traversal = new PreorderTraversal();

        final List<Integer> list = new ArrayList<>();

        traversal.traverse(create(), consumer(list));

        Assertions.assertThat(list).containsExactly(5, 1, 4, 3, 6);
    }

    @Test
    void inorder() {
        final InorderTraversal traversal = new InorderTraversal();

        final List<Integer> list = new ArrayList<>();

        traversal.traverse(create(), consumer(list));

        Assertions.assertThat(list).containsExactly(1, 5, 3, 4, 6);
    }

    @Test
    void postorder() {
        final PostorderTraversal traversal = new PostorderTraversal();

        final List<Integer> list = new ArrayList<>();

        traversal.traverse(create(), consumer(list));

        Assertions.assertThat(list).containsExactly(1, 3, 6, 4, 5);
    }

    static TraversalConsumer consumer(final List<Integer> l) {
        return new TraversalConsumer() {
            private final List<Integer> list = l;

            @Override
            public void apply(TreeNode node) {
                list.add(node.val);
            }
        };
    }

    static TreeNode create() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);

        root.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        return root;
    }
}