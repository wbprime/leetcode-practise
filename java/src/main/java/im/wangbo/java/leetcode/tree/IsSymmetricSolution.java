package im.wangbo.java.leetcode.tree;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/49/
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * @author Elvis Wang
 */
class IsSymmetricSolution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;

        return treeMirrors(root.left, root.right);
    }

    boolean treeMirrors(final TreeNode node1, final TreeNode node2) {
        if (null == node1 && null == node2) return true;
        if (null == node1 || null == node2) return false;

        return node1.val == node2.val && treeMirrors(node1.left, node2.right) && treeMirrors(node1.right, node2.left);
    }
}
