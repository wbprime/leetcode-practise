package im.wangbo.wbprime.leetcode.binarytree;

import im.wangbo.wbprime.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.function.IntConsumer;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class LevelOrderTraverse {
    public void traverse(final TreeNode root, final IntConsumer consumer) {
        if (root == null) return;

        final LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            final TreeNode node = q.removeFirst();

            consumer.accept(node.val);
            if (node.left != null) q.addLast(node.left);
            if (node.right != null) q.addLast(node.right);
        }
    }
}
