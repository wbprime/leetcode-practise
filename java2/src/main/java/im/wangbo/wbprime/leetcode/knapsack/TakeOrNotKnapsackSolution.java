package im.wangbo.wbprime.leetcode.knapsack;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class TakeOrNotKnapsackSolution {
    public boolean[] solveItems(int[] prices, int[] values, int total) {
        if (prices.length != values.length) throw new IllegalArgumentException("Count not matches");

        final int len = prices.length;
        if (len == 0) return new boolean[]{};

        final boolean[] result = new boolean[len];
        if (total == 0) {
            for (int i = 0; i < result.length; i++) {
                result[i] = false;
            }
            return result;
        }

        final int[] row = new int[total + 1];
        for (int i = 0; i <= total; i++) row[i] = 0;

        boolean[][] tagged = new boolean[len][total];
        for (int i = 0; i < len; i++) {
            final boolean[] a = new boolean[total + 1];
            for (int j = 0; j <= total; j++) {
                a[j] = false;
            }
            tagged[i] = a;
        }

        for (int i = 0; i < len; i++) {
            for (int j = total; j > 0; j--) {
                if (j >= prices[i]) {
                    final int o1 = row[j];
                    final int o2 = row[j - prices[i]] + values[i];
                    if (o1 < o2) {
                        row[j] = o2;
                        tagged[i][j - 1] = true;
                    } else {
                        row[j] = o1;
                        tagged[i][j - 1] = false;
                    }
                } else {
                    tagged[i][j] = false;
                }
            }

//            System.out.println(Arrays.toString(row));
        }

        int left = total - 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = tagged[i][left];

            if (result[i]) {
                left = left - prices[i];
            }
        }

        return result;
    }

    public int solve(int[] prices, int[] values, int total) {
        if (prices.length != values.length) throw new IllegalArgumentException("Count not matches");

        final int len = prices.length;
        if (len == 0 || total == 0) return 0;

        int[] row = new int[total + 1];
        for (int i = 0; i <= total; i++) {
            row[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            for (int j = total; j >= prices[i]; j--) {
                if (row[j] < row[j - prices[i]] + values[i]) {
                    row[j] = row[j - prices[i]] + values[i];
                }
            }

//            System.out.println(Arrays.toString(row));
        }

        return row[total];
    }

    public int solveLegacy(int[] prices, int[] values, int total) {
        if (prices.length != values.length) throw new IllegalArgumentException("Count not matches");

        final int len = prices.length;
        if (len == 0 || total == 0) return 0;

        int[] lastRow = new int[total + 1];
        int[] curRow = new int[total + 1];
        for (int i = 0; i <= total; i++) {
            lastRow[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            curRow[0] = 0;
            for (int j = 1; j <= total; j++) {
                if (j >= prices[i]) {
                    final int o1 = lastRow[j];
                    final int o2 = lastRow[j - prices[i]] + values[i];
                    if (o1 < o2) {
                        curRow[j] = o2;
                    } else {
                        curRow[j] = o1;
                    }
                } else {
                    curRow[j] = lastRow[j];
                }
            }

//            System.out.println(Arrays.toString(curRow));

            int[] tmp = lastRow;
            lastRow = curRow;
            curRow = tmp;
        }

        return lastRow[total];
    }
}
