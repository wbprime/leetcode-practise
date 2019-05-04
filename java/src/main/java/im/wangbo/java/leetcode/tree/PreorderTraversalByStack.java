package im.wangbo.java.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elvis Wang
 */
class PreorderTraversalByStack {
    public void traverse(final TreeNode root, final TraversalConsumer consumer) {
        if (null == root) return;

        final List<TreeNode> stack = new ArrayList<>();

        TreeNode cur = root;
        while (null != cur || !stack.isEmpty()) {
            if (null != cur) {
                stack.add(cur);

                consumer.apply(cur);

                cur = cur.left;
            } else {
                TreeNode n = stack.remove(stack.size() - 1);
                cur = n.right;
            }
        }
    }
}
