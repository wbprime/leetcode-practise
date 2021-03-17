package im.wangbo.wbprime.leetcode.maxsum;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MaxProfitSolution {
    public int maxProfit(final int[] arr) {
        if (arr.length < 2) return 0;

        int sum = arr[1] - arr[0];
        int maxSum = sum;
        for (int i = 2; i < arr.length; i++) {
            final int profit = arr[i] - arr[i - 1];
            if (sum < 0) {
                sum = profit;
            } else {
                sum += profit;
            }

            if (sum > maxSum) maxSum = sum;
        }
        return Math.max(0, maxSum);
    }

    public int[] maxProfitAndBeginEnd(final int[] arr) {
        final int[] result = new int[3];
        result[0] = 0; // max profit
        result[1] = -1; // beg
        result[2] = -1; // end

        if (arr.length < 2) return result;

        int sum = arr[1] - arr[0];
        result[0] = sum;
        result[1] = 0;
        result[2] = 1;

        int beg = 0;
        for (int i = 2; i < arr.length; i++) {
            final int profit = arr[i] - arr[i - 1];
            if (sum < 0) {
                sum = profit;

                beg = i - 1;
            } else {
                sum += profit;
            }

            if (sum >= result[0]) {
                result[0] = sum;
                result[1] = beg;
                result[2] = i;
            }
        }

        if (result[0] <= 0) {
            result[0] = 0;
            result[1] = -1;
            result[2] = -1;
        }

        return result;
    }
}
