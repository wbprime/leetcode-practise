package im.wangbo.java.leetcode;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/47/
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @author Elvis Wang
 */
class TreeMaxDepthSolution {
    public int maxDepth(TreeNode root) {
        if (null == root) return 0;

        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);

        return maxL > maxR ? maxL + 1 : maxR + 1;
    }
}
