package im.wangbo.java.leetcode.array;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * @author Elvis Wang
 */
class RotateArraySolution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) return;

        k = k % len;
        if (0 == k) return;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    void reverse(int[] nums, int beg, int end) {
        while (beg < end) {
            int tmp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = tmp;
            beg ++;
            end --;
        }
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) return;

        k = k % len;

        while (k > 0) {
            int last = nums[len - 1];
            for (int i = len - 1; i > 0; i --) {
                nums[i] = nums[i - 1];
            }
            nums[0] = last;

            k --;
        }
    }
}
