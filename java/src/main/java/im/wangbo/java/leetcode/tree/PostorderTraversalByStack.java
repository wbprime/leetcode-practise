package im.wangbo.java.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elvis Wang
 */
class PostorderTraversalByStack {
    public void traverse(final TreeNode root, final TraversalConsumer consumer) {
        if (null == root) return;

        final List<TreeNode> stack = new ArrayList<>();
        stack.add(root);

        TreeNode cur = root;
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            cur = stack.get(stack.size() - 1);
            if (cur.left == null && cur.right == null ||
                    (prev != null && (prev == cur.left || prev == cur.right))) {
                consumer.apply(stack.remove(stack.size() - 1));
                prev = cur;
            } else {
                if (cur.right != null) stack.add(cur.right);
                if (cur.left != null) stack.add(cur.left);
            }
        }
    }
}
