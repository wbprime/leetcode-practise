package im.wangbo.java.leetcode;

/**
 * See https://leetcode-cn.com/problems/merge-intervals/
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author Elvis Wang
 */
public class MergeIntervalsSolution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return intervals;

        int x = 0;
        while (x < n) {
            final int[] arr1 = intervals[x];
            int i = x + 1;
            while (i < n) {
                final int[] arr2 = intervals[i];
                if (arr1[0] > arr2[1] || arr1[1] < arr2[0]) {
                    i++;
                } else {
                    arr1[0] = arr1[0] < arr2[0] ? arr1[0] : arr2[0];
                    arr1[1] = arr1[1] > arr2[1] ? arr1[1] : arr2[1];

                    n --;
                    if (i != n) {
                        intervals[i] = intervals[n];
                    }

                    i = x + 1;
                }
            }

            x++;
        }

        final int[][] result = new int[n][2];
        for (int j = 0; j < n; j++) {
            result[j][0] = intervals[j][0];
            result[j][1] = intervals[j][1];
        }

        return result;
    }
}
