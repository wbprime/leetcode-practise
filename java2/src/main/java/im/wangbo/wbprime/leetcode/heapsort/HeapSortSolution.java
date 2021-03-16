package im.wangbo.wbprime.leetcode.heapsort;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class HeapSortSolution {
    public void sort(final int[] arr) {
        if (arr.length < 2) return;

        heapify(arr, 0, arr.length);
        for (int i = 1; i < arr.length; i++) {
            swap(arr, 0, arr.length - i);
            heapify(arr, 0, arr.length - i);
        }
    }

    private void heapify(final int[] arr, final int beg /* inclusive */, final int end /* exclusive */) {
        for (int i = end / 2 - 1; i >= beg; i--) {
            final int ll = i * 2 + 1;
            final int rl = (i + 1) * 2;

            if (arr[i] < arr[ll]) swap(arr, i, ll);
            if (rl < end && arr[i] < arr[rl]) swap(arr, i, rl);
        }
    }

    private void swap(final int[] arr, final int a, final int b) {
        if (a == b) return;

        final int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
