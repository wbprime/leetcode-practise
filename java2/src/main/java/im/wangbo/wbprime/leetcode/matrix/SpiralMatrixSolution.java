package im.wangbo.wbprime.leetcode.matrix;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class SpiralMatrixSolution {
    public int[][] generate(final int n) {
        final int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[n];
        }

        int k = 1;
        for (int i = 0; i < n / 2; i++) {
            // Top
            for (int j = i; j < n - 1 - i; j++) matrix[i][j] = k++;
            // Right
            for (int j = i; j < n - 1 - i; j++) matrix[j][n - 1 - i] = k++;
            // Bottom
            for (int j = n - 1 - i; j > i; j--) matrix[n - 1 - i][j] = k++;
            // Left
            for (int j = n - 1 - i; j > i; j--) matrix[j][i] = k++;
        }

        if (n % 2 != 0) {
            matrix[n / 2][n / 2] = k;
        }

        return matrix;
    }

    public int[] walk(final int[][] matrix) {
        final int m = matrix.length;
        if (m == 0) return new int[]{};

        final int n = matrix[0].length;
        if (n == 0) return new int[]{};

        final int[] result = new int[m * n];
        int k = 0;
        for (int i = 0; i < Math.min(m, n) / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) result[k++] = matrix[i][j];
            for (int j = i; j < m - 1 - i; j++) result[k++] = matrix[j][n - 1 - i];
            for (int j = n - 1 - i; j > i; j--) result[k++] = matrix[m - 1 - i][j];
            for (int j = m - 1 - i; j > i; j--) result[k++] = matrix[j][i];
        }

        if (m < n) {
            if (m % 2 != 0) {
                final int tmp = m / 2;
                for (int i = tmp; i <= n - 1 - tmp; i++) result[k++] = matrix[tmp][i];
            }
        } else {
            if (n % 2 != 0) {
                final int tmp = n / 2;
                for (int i = tmp; i <= m - 1 - tmp; i++) result[k++] = matrix[i][tmp];
            }
        }

        return result;
    }
}
