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
class AlternateLevelOrderTraverse {
    public void traverse(final TreeNode root, final IntConsumer consumer) {
        if (root == null) return;

        final LinkedList<TreeNode> q = new LinkedList<>();
        q.push(root);

        int depth = 0;
        while (!q.isEmpty()) {
            final int n = q.size();
            if (depth % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    final TreeNode cur = q.removeFirst();

                    consumer.accept(cur.val);

                    if (cur.right != null) q.addLast(cur.right);
                    if (cur.left != null) q.addLast(cur.left);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    final TreeNode cur = q.removeLast();

                    consumer.accept(cur.val);

                    if (cur.left != null) q.addFirst(cur.left);
                    if (cur.right != null) q.addFirst(cur.right);
                }
            }

            depth++;
        }
    }
}
