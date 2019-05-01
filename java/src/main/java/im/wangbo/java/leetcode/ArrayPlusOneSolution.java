package im.wangbo.java.leetcode;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author Elvis Wang
 */
public class ArrayPlusOneSolution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        digits[len - 1] += 1;

        for (int i = len - 1; i > 0; i--) {
            if (digits[i] <= 9) {
                break;
            } else {
                digits[i] = 0;
                digits[i - 1] += 1;
            }
        }

        if (digits[0] > 9) {
            final int[] result = new int[len + 1];
            result[0] = 1;
            result[1] = 0;
            for (int i = 1; i < len; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        } else {
            return digits;
        }
    }
}
