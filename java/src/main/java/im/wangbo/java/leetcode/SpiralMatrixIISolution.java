package im.wangbo.java.leetcode;

/**
 * See https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author Elvis Wang
 */
public class SpiralMatrixIISolution {
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[0][0];

        final int[][] result = new int[n][n];

        int num = 1;

        int r = 0;
        int r_max;
        while ((r_max = n - 1 - r) > r) {
            int i = r;
            int j = r;

            // Top
            while (j < r_max) {
                result[i][j++] = num++;
            }
            // Right
            while (i < r_max) {
                result[i++][j] = num++;
            }
            // Bottom
            while (j > r) {
                result[i][j--] = num++;
            }
            // Left
            while (i > r) {
                result[i--][j] = num++;
            }

            r++;
        }

        if (r_max == r) {
            result[r][r] = num;
        }

        return result;
    }
}
