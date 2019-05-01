package im.wangbo.java.leetcode;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * @author Elvis Wang
 */
public class ArrayContainsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if (len <= 1) return false;

        boolean found = false;

        int cur = 1;
        while (cur < len) {
            while (cur < len && nums[cur] > nums[cur - 1]) cur ++;

            if (cur == len) return false;

            int i = cur;
            while (i > 0 && nums[i] < nums[i - 1]) {
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
                i --;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                found = true;
                break;
            }
        }

        return found;
    }
}
