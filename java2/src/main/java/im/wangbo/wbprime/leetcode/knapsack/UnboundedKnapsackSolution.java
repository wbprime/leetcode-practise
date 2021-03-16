package im.wangbo.wbprime.leetcode.knapsack;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class UnboundedKnapsackSolution {
    public int solve(int[] prices, int[] values, int total) {
        if (prices.length != values.length) throw new IllegalArgumentException("Count not matches");

        final int len = prices.length;
        if (len == 0 || total == 0) return 0;

        int[] row = new int[total + 1];
        for (int i = 0; i <= total; i++) {
            row[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            for (int j = prices[i]; j <= total; j++) {
                if (row[j] < row[j - prices[i]] + values[i]) {
                    row[j] = row[j - prices[i]] + values[i];
                }
            }

//            System.out.println(Arrays.toString(row));
        }

        return row[total];
    }
}
