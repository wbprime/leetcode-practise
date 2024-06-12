package im.wangbo.wbprime.leetcode.knapsack;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class BuyThenSellStocksSolution {
    public int solve(int[] buyPrices, int[] sellPrices, int totalAmount) {
        if (buyPrices.length != sellPrices.length) throw new IllegalArgumentException("Count not matches");

        final int len = buyPrices.length;
        if (len == 0 || totalAmount <= 0) return 0;

        for (int i = 0; i < sellPrices.length; i++) {
            sellPrices[i] = sellPrices[i] - buyPrices[i];
        }

        int[] row = new int[totalAmount + 1];
        for (int i = 0; i <= totalAmount; i++) {
            row[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            int w = sellPrices[i];
            if (w > 0) {
                for (int j = buyPrices[i]; j <= totalAmount; j++) {
                    if (row[j] < row[j - buyPrices[i]] + w) {
                        row[j] = row[j - buyPrices[i]] + w;
                    }
                }
            }
        }

        return row[totalAmount];
    }
}
