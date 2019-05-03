package im.wangbo.java.leetcode.tree;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class PreorderTraversal {
    void traverse(final TreeNode root, final TraversalConsumer consumer) {
        if (null == root) return;

        consumer.apply(root);

        if (null != root.left) traverse(root.left, consumer);

        if (null != root.right) traverse(root.right, consumer);
    }
}
