package im.wangbo.wbprime.leetcode.multimerge;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MultiMergeSolution {
    public int[] sort(int[][] data) {
        int n = 0;
        for (int i = 0; i < data.length; i++) {
            n += data[i].length;
        }

        if (n == 0) return new int[]{};

        int heapLen = 0;
        final HeapItem[] heap = new HeapItem[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > 0) heap[heapLen++] = new HeapItem(i, 0);
        }
        heapify(heap, 0, heapLen, data);

        final int[] result = new int[n];

        int k = 0;
        while (k < n) {
            if (heapLen == 1) break;

            final HeapItem cur = heap[0];
            result[k++] = value(data, cur);

            if (cur.col + 1 < data[cur.row].length) {
                cur.col++;
            } else {
                heap[0] = heap[--heapLen];
                heap[heapLen] = null;
            }
            heapify(heap, 0, heapLen, data);
        }

        {
            final int[] src = data[heap[0].row];
            for (int i = heap[0].col; i < src.length; i++) {
                result[k++] = src[i];
            }
        }

        return result;
    }

    private int value(final int[][] data, final HeapItem idx) {
        return data[idx.row][idx.col];
    }

    private void swap(final HeapItem[] arr, int a, int b) {
        if (a == b) return;
        final HeapItem tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private void heapify(final HeapItem[] arr, final int beg, final int end, final int[][] data) {
        for (int i = end / 2 - 1; i >= beg; i--) {
            final int ll = i * 2 + 1;
            final int rl = ll + 1;
            if (value(data, arr[i]) > value(data, arr[ll])) swap(arr, i, ll);
            if (rl < end && value(data, arr[i]) > value(data, arr[rl])) swap(arr, i, rl);
        }
    }

    static class HeapItem {
        public int row;
        public int col;

        public HeapItem(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "[" + row + ", " + col + '}';
        }
    }
}
