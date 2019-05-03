package im.wangbo.java.leetcode.tree;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/51/
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @author Elvis Wang
 */
class SortedArrayToBSTSolution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || nums.length == 0) return null;

        return createFromArray(nums, 0, nums.length - 1);
    }

    private TreeNode createFromArray(final int[] nums, int beg, int end) {
        if (beg > end) return null;

        int mid = (beg + end) / 2;
        final TreeNode root = new TreeNode(nums[mid]);
        if (beg < mid) {
            root.left = createFromArray(nums, beg, mid - 1);
        }
        if (mid < end) {
            root.right = createFromArray(nums, mid + 1, end);
        }
        return root;
    }
}
