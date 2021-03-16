package im.wangbo.wbprime.leetcode.mergesort;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MergeSortRecursivelySolution {
    public void sort(final int[] arr) {
        if (arr.length < 2) return;

        final int[] b = new int[arr.length];
        mergeSort(arr, b, 0, arr.length);
    }

    private void mergeSort(final int[] arr, final int[] b, final int beg, final int end) {
        if (beg < end - 1) {
            final int mid = (beg + end) / 2;
            mergeSort(arr, b, beg, mid);
            mergeSort(arr, b, mid, end);

            int n = beg;
            int i = beg;
            int j = mid;
            while (i < mid && j < end) {
                if (arr[i] < arr[j]) {
                    b[n++] = arr[i++];
                } else {
                    b[n++] = arr[j++];
                }
            }

            while (i < mid) b[n++] = arr[i++];
            while (j < end) b[n++] = arr[j++];

            for (int k = beg; k < end; k++) arr[k] = b[k];
        }
    }
}
