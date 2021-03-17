package im.wangbo.wbprime.leetcode.maxsum;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MaxContinueousSubArraySumSolution {
    public int maxSum(final int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        int sum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }

            if (sum > maxSum) maxSum = sum;
        }

        return maxSum;
    }

    public int[] maxSumAndBeginEnd(final int[] arr) {
        final int[] result = new int[3];
        result[0] = 0;
        result[1] = -1;
        result[2] = -1;

        if (arr.length == 0) return result;

        result[0] = arr[0];
        result[1] = 0;
        result[2] = 0;
        if (arr.length == 1) return result;

        int sum = arr[0];
        int beg = 0;
        int end = 0;
        for (int i = 1; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
                beg = end = i;
            } else {
                sum += arr[i];
                end = i;
            }

            if (sum > result[0]) {
                result[0] = sum;
                result[1] = beg;
                result[2] = end;
            }
        }

        return result;
    }
}
