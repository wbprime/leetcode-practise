package im.wangbo.wbprime.leetcode.quicksort;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class QuickSortSolution {
    public void sort(final int[] arr) {
        if (arr.length < 2) return;

        quickSort(arr, 0, arr.length);
    }

    private void quickSort(final int[] arr, final int beg, final int end) {
        if (beg < end - 1) {
            final int mid = partition(arr, beg, end);
            quickSort(arr, beg, mid);
            quickSort(arr, mid + 1, end);
        }
    }

    private int partition(
            final int[] arr,
            final int beg /* inclusive */,
            final int end /* exclusive */
    ) {
        int pivot = arr[beg];

        int i = beg;
        int j = end - 1;
        while (i < j) {
            while (i < j && arr[j] >= pivot) j--;
            if (i < j) arr[i] = arr[j];

            while (i < j && arr[i] <= pivot) i++;
            if (i < j) arr[j] = arr[i];
        }
        if (i != beg) arr[i] = pivot;

        return i;
    }
}
