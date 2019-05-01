package im.wangbo.java.leetcode;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author Elvis Wang
 */
public class ArraySingleNumberSolution {
    public int singleNumber(int[] nums) {
        int len = nums.length;

        int v = nums[0];
        for (int i = 1; i < len; i++) {
            v = v ^ nums[i];
        }

        return v;
    }
}
