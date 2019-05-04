package im.wangbo.java.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/85/
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author Elvis Wang
 */
class InorderTraversalByStack {
    public void traverse(final TreeNode root, final TraversalConsumer consumer) {
        if (null == root) return;

        final List<TreeNode> stack = new ArrayList<>();

        TreeNode cur = root;
        while (null != cur || !stack.isEmpty()) {
            if (null != cur) {
                stack.add(cur);
                cur = cur.left;
            } else {
                TreeNode n = stack.remove(stack.size() - 1);
                consumer.apply(n);
                cur = n.right;
            }
        }
    }
}
