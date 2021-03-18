package im.wangbo.wbprime.leetcode.permutate;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class NextPermuteSolution {
    public int[] solve(final int[] arr) {
        if (arr.length < 2) return arr;

        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;

        if (i < 0) return arr;

        int j = arr.length - 1;
        while (j > i && arr[j] <= arr[i]) j--;

        if (j != i) {
            swap(arr, i, j);

            int ii = i + 1;
            int jj = arr.length - 1;
            while (ii < jj) {
                swap(arr, ii++, jj--);
            }
        }
        return arr;
    }

    private void swap(final int[] arr, int beg, int end) {
        if (beg != end) {
            int tmp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = tmp;
        }
    }
}
