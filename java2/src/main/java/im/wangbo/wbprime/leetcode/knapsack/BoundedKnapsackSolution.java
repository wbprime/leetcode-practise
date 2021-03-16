package im.wangbo.wbprime.leetcode.knapsack;

import java.util.Arrays;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class BoundedKnapsackSolution {
    public int solve(int[] prices, int[] values, int[] counts, int total) {
        if (prices.length != values.length || values.length != counts.length)
            throw new IllegalArgumentException("Count not matches");

        final int len = prices.length;
        if (len == 0 || total == 0) return 0;

        int[] row = new int[total + 1];
        for (int i = 0; i <= total; i++) {
            row[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            if (counts[i] * prices[i] > total) {
                solveUnboundedOneOnce(row, prices[i], values[i]);
            } else {
                int k = 1;
                int left = counts[i];
                while (k <= left) {
                    solveZeroOneOnce(row, k * prices[i], k * values[i]);

                    left = left - k;
                    k = k * 2;
                }

                if (left > 0) solveZeroOneOnce(row, left * prices[i], left * values[i]);
            }

            System.out.println(Arrays.toString(row));
        }

        return row[total];
    }

    private void solveZeroOneOnce(final int[] arr, int price, int value) {
        for (int i = arr.length - 1; i >= price; i--) {
            if (arr[i] < arr[i - price] + value) arr[i] = arr[i - price] + value;
        }
    }

    private void solveUnboundedOneOnce(final int[] arr, int price, int value) {
        for (int i = price; i < arr.length; i++) {
            if (arr[i] < arr[i - price] + value) arr[i] = arr[i - price] + value;
        }
    }
}
