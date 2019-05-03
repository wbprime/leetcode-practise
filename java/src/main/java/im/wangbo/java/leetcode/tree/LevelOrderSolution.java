package im.wangbo.java.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/50/
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author Elvis Wang
 */
class LevelOrderSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        final List<List<Integer>> result = new ArrayList<List<Integer>>();

        int n;
        while ((n = queue.size()) != 0) {
            final List<Integer> level = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                final TreeNode treeNode = queue.remove();

                level.add(treeNode.val);

                if (null != treeNode.left) queue.add(treeNode.left);
                if (null != treeNode.right) queue.add(treeNode.right);
            }
            result.add(level);
        }

        return result;
    }
}
