package im.wangbo.wbprime.leetcode.binarytree;

import im.wangbo.wbprime.leetcode.TreeNode;

import java.util.function.IntConsumer;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class PostOrderTraverse {
    public void traverse(final TreeNode root, final IntConsumer consumer) {
        if (root == null) return;

        traverse(root.left, consumer);
        traverse(root.right, consumer);
        consumer.accept(root.val);
    }
}
