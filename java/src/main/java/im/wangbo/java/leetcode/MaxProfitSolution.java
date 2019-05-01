package im.wangbo.java.leetcode;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
public class MaxProfitSolution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;

        int profit = 0;
        int cur = 1;
        while (cur < len) {
            while (cur < len && prices[cur] > prices[cur - 1]) {
                profit = profit + prices[cur] - prices[cur - 1];
                cur++;
            }

            if (cur == len) break;

            cur ++;
        }

        return profit;
    }
}
