package im.wangbo.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * See https://leetcode-cn.com/problems/spiral-matrix/
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 *
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author Elvis Wang
 */
public class SpiralMatrixSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return Collections.emptyList();

        int rows = matrix.length;
        if (rows == 0) return Collections.emptyList();

        int cols = matrix[0].length;
        if (cols == 0) return Collections.emptyList();

        final List<Integer> result = new ArrayList<Integer>();
        int n = 0;
        int i_end;
        int j_end;
        while ((i_end = rows - n - 1) > n && (j_end = cols - n - 1) > n) {
            int i = n;
            int j = n;

            // Top
            while (j < j_end) {
                result.add(matrix[i][j++]);
            }

            // Right
            while (i < i_end) {
                result.add(matrix[i++][j]);
            }

            // Bottom
            while (j > n) {
                result.add(matrix[i][j--]);
            }

            // Left
            while (i > n) {
                result.add(matrix[i--][j]);
            }

            n++;
        }

        i_end = rows - n - 1;
        j_end = cols - n - 1;

        if (i_end == n) {
            int j = n;

            while (j <= j_end) {
                result.add(matrix[n][j++]);
            }
        } else if (j_end == n) {
            i_end = rows - n - 1;
            int i = n;

            while (i <= i_end) {
                result.add(matrix[i++][n]);
            }
        }

        return result;
    }
}
