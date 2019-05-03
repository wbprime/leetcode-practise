package im.wangbo.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/48/
 *
 *   验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author Elvis Wang
 */
class TreeIsValidBSTSolution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (null == root) return true;

        final List<Integer> items = new ArrayList<Integer>();

        inorderTraverse(root, new AppendValue(items));

        for (int i = 1; i < items.size(); i++) {
            if (items.get(i) <= items.get(i - 1)) return false;
        }

        return true;
    }

    static class AppendValue implements Consumer {
        private final List<Integer> list;

        AppendValue(final List<Integer> list) {
            this.list = list;
        }

        @Override
        public void apply(TreeNode node) {
            list.add(node.val);
        }
    }

    static interface Consumer {
        void apply(final TreeNode node);
    }

    private void inorderTraverse(TreeNode root, Consumer consumer) {
        if (null == root) return;

        if (null != root.left) inorderTraverse(root.left, consumer);

        consumer.apply(root);

        if (null != root.right) inorderTraverse(root.right, consumer);
    }
}
