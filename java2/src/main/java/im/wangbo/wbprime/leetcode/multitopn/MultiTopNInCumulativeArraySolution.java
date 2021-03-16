package im.wangbo.wbprime.leetcode.multitopn;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MultiTopNInCumulativeArraySolution {
    public int[][] solve(final int[] existed, final int[] daily, final int n) {
        if (daily.length == 0) return new int[0][];

        final int[] empty = new int[]{};

        final int[][] result = new int[daily.length][];
        if (n <= 0) {
            for (int i = 0; i < result.length; i++) {
                result[i] = empty;
            }
            return result;
        }

        final int[] heap = new int[n];
        int heapLen = 0;
        for (int i = 0; i < existed.length; i++) {
            if (heapLen < n) {
                heap[heapLen++] = existed[i];
            } else {
                heapify(heap, heapLen);
                if (heap[0] < existed[i]) {
                    heap[0] = existed[i];
                }
            }
        }

        for (int i = 0; i < daily.length; i++) {
            if (heapLen < n) {
                heap[heapLen++] = daily[i];
            } else {
                heapify(heap, heapLen);
                if (heap[0] < daily[i]) {
                    heap[0] = daily[i];
                }
            }

            final int[] tmp = new int[heapLen];
            for (int j = 0; j < heapLen; j++) tmp[j] = heap[j];
            sort(tmp);
            result[i] = tmp;
        }
        return result;
    }

    private void sort(final int[] arr) {
        if (arr.length < 2) return;

        heapify(arr, arr.length);
        for (int i = 1; i < arr.length; i++) {
            swap(arr, 0, arr.length - i);
            heapify(arr, arr.length - i);
        }
    }

    private void heapify(final int[] arr, final int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            final int ll = i * 2 + 1;
            final int rl = ll + 1;
            if (arr[i] > arr[ll]) swap(arr, i, ll);
            if (rl < len && arr[i] > arr[rl]) swap(arr, i, rl);
        }
    }

    private void swap(final int[] arr, final int a, final int b) {
        if (a == b) return;

        final int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
