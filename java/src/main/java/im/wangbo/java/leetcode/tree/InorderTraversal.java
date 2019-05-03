package im.wangbo.java.leetcode.tree;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class InorderTraversal {
    void traverse(final TreeNode root, final TraversalConsumer consumer) {
        if (null == root) return;

        if (null != root.left) traverse(root.left, consumer);

        consumer.apply(root);

        if (null != root.right) traverse(root.right, consumer);
    }
}
