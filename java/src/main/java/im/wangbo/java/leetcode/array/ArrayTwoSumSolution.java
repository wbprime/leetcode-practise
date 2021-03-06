package im.wangbo.java.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author Elvis Wang
 */
class ArrayTwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        final int[] result = {-1, -1};

        int len = nums.length;

        final Map<Integer, Integer> map = new HashMap<Integer, Integer>(len);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            final int tmp = target - nums[i];
            final Integer v = map.get(tmp);

            if (null != v && v != i) {
                if (i < v) {
                    result[0] = i;
                    result[1] = v;
                } else {
                    result[0] = v;
                    result[1] = i;
                }
                break;
            }
        }

        return result;
    }
}
