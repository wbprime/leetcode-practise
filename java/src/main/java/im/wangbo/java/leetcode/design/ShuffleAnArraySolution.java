package im.wangbo.java.leetcode.design;

import java.util.Arrays;
import java.util.Random;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/58/
 *
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 * @author Elvis Wang
 */
class ShuffleAnArraySolution {
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    public ShuffleAnArraySolution(int[] nums) {
        this.original = nums;
    }

    private final int[] original;

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        final int[] result = Arrays.copyOf(original, original.length);

        final Random r = new Random();
        for (int i = 1; i < result.length; i++) {
            int idx = r.nextInt(i + 1);
            if (idx != i) {
                int tmp = result[idx];
                result[idx] = result[i];
                result[i] = tmp;
            }
        }
        return result;
    }
}
