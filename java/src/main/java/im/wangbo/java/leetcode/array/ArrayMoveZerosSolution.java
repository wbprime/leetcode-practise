package im.wangbo.java.leetcode.array;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author Elvis Wang
 */
class ArrayMoveZerosSolution {
    public void moveZeros(int[] nums) {
        int len = nums.length;
        if (len <= 1) return;

        int l = 0;
        int r = 0;
        while (l < len) {
            while (l < len && nums[l] != 0) l++;

            if (l == len) break;

            r = l + 1;
            while (r < len && nums[r] == 0) r++;

            if (r == len) break;

            nums[l++] = nums[r];
            nums[r] = 0;
        }
    }
}
