package im.wangbo.wbprime.leetcode.multitopn;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MultiTopNInFixArraySolution {
    public int[][] solve(final int[] existed, final int[] daily, final int m, final int n) {
        if (daily.length == 0) return new int[0][];

        final int[] empty = new int[]{};

        final int[][] result = new int[daily.length][];
        if (n <= 0) {
            for (int i = 0; i < result.length; i++) {
                result[i] = empty;
            }
            return result;
        }

        final Item[] heap = new Item[m];
        int idx = 0;
        for (int i = 0; i < existed.length; i++) {
            append(heap, idx++, existed[i]);
        }

        for (int i = 0; i < daily.length; i++) {
            append(heap, idx++, daily[i]);

            final int len = Math.min(m, idx);
            sort(heap, len);

            final int[] tmp = new int[Math.min(len, n)];
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = heap[j].value;
            }

            result[i] = tmp;
        }
        return result;
    }

    private void append(final Item[] arr, final int idx, final int value) {
        if (idx < arr.length) {
            arr[idx] = new Item(idx, value);
        } else {
            for (int i = 0; i < idx; i++) {
                if (arr[i].index == idx - arr.length) {
                    arr[i].index = idx;
                    arr[i].value = value;
                    break;
                }
            }
        }
    }

    private void sort(final Item[] arr, final int len) {
        if (arr.length < 2) return;

        heapify(arr, len);
        for (int i = 1; i < len; i++) {
            swap(arr, 0, len - i);
            heapify(arr, len - i);
        }
    }

    private void heapify(final Item[] arr, final int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            final int ll = i * 2 + 1;
            final int rl = ll + 1;
            if (arr[i].value > arr[ll].value) swap(arr, i, ll);
            if (rl < len && arr[i].value > arr[rl].value) swap(arr, i, rl);
        }
    }

    private void swap(final Item[] arr, final int a, final int b) {
        if (a == b) return;

        final Item tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static class Item {
        public int index;
        public int value;

        public Item(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }
}
