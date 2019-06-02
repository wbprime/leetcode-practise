package im.wangbo.java.leetcode;

import java.util.List;

/**
 * See https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1030/
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * @author Elvis Wang
 */
public class MinimumTotalSolution {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int n = triangle.size();
        if (n == 0) return 0;
        if (n == 1) return triangle.get(0).get(0);

        final int[] arr = new int[n];

        arr[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                arr[j] = arr[j] < arr[j - 1] ? arr[j] : arr[j - 1];
                arr[j] = arr[j] + triangle.get(i).get(j);
            }
            arr[0] = arr[0] + triangle.get(i).get(0);
        }

        int result = arr[0];
        for (int i = 1; i < n; i++) {
            result = result < arr[i] ? result : arr[i];
        }
        return result;
    }
}
