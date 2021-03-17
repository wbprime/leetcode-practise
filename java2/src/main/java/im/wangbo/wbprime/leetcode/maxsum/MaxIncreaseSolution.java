package im.wangbo.wbprime.leetcode.maxsum;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MaxIncreaseSolution {
    public int solve(final int[] arr) {
        if (arr.length < 2) return 0;

        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                sum += arr[i] - arr[i - 1];
            }
        }

        return sum;
    }
}
