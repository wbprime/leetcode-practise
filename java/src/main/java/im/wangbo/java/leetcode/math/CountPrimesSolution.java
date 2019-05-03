package im.wangbo.java.leetcode.math;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/61/
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @author Elvis Wang
 */
class CountPrimesSolution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        // 0 -> 2
        final byte[] marks = new byte[n - 2];

        final int NON_PRIME = 1;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] != NON_PRIME) {
                for (int j = 2; (i + 2) * j < n; j++) {
                    marks[(i + 2) * j - 2] = NON_PRIME;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] != NON_PRIME) cnt++;
        }
        return cnt;
    }
}
