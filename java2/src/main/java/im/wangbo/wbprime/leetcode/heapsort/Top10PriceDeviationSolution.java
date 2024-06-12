package im.wangbo.wbprime.leetcode.heapsort;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class Top10PriceDeviationSolution {
    public int[] topn(final int[] openPrices, final int[] closePrices) {
        if (openPrices.length != closePrices.length)
            throw new IllegalArgumentException("Illegal input");

        final int N = 10;
        final int[] topN = new int[N];

        int topNIdx = 0;

        int priceIdx = 0;
        while (topNIdx < N && priceIdx < openPrices.length) {
            final int open = openPrices[priceIdx];
            final int close = closePrices[priceIdx];
            priceIdx++;

            final int delta = close - open;
            if (delta <= 30 && delta >= -30) {
                topN[topNIdx] = delta;
                topNIdx++;
            }
        }

        if (topNIdx == 0) return new int[0];

        if (topNIdx < N) {
            final int[] arr = new int[topNIdx];
            System.arraycopy(topN, 0, arr, 0, topNIdx);
            sort(arr);
            return arr;
        }

        makeHeap(topN);
        while (priceIdx < openPrices.length) {
            final int open = openPrices[priceIdx];
            final int close = closePrices[priceIdx];
            priceIdx++;

            final int delta = close - open;
            if (delta <= 30 && delta >= -30) {
                if (topN[0] < delta) {
                    topN[0] = delta;
                    heapify(topN, 0, N);
                }
            }
        }
        sort(topN);
        return topN;
    }

    private void sort(final int[] arr) {
        makeHeap(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // call max heapify on the reduced heap
            heapify(arr, 0, i);
        }
    }

    private void makeHeap(final int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, i, arr.length);
    }

    private void heapify(final int[] arr, final int beg, final int len) {
        int min = beg;

        int l = 2 * beg + 1;
        int r = 2 * beg + 2;

        // adjust left
        if (l < len && arr[l] < arr[min])
            min = l;

        // adjust right
        if (r < len && arr[r] < arr[min])
            min = r;

        // adjust sub tree
        if (min != beg) {
            swap(arr, beg, min);

            heapify(arr, min, len);
        }
    }

    private void swap(final int[] arr, final int a, final int b) {
        if (a == b) return;

        final int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
