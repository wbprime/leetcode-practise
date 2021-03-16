package im.wangbo.wbprime.leetcode.knapsack;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class TakeOrNotFitKnapsackSolution {
    public int solve(int[] prices, int[] values, int total) {
        if (prices.length != values.length) throw new IllegalArgumentException("Count not matches");

        final int len = prices.length;
        if (len == 0 || total == 0) return 0;

        final int[] row = new int[total + 1];
        row[0] = 0;
        for (int i = 1; i <= total; i++) {
            row[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < len; i++) {
            for (int j = total; j >= prices[i]; j--) {
                final int o1 = row[j];
                final int o2 = row[j - prices[i]] + values[i];
                if (o1 < o2) {
                    row[j] = o2;
                }
            }

//            System.out.println(Arrays.toString(row));
        }

        return row[total] < 0 ? -1 : row[total];
    }
}
