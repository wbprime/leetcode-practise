package im.wangbo.wbprime.leetcode.mergesort;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MergeSortLooplySolution {
    public void sort(final int[] arr) {
        if (arr.length < 2) return;

        final int[] b = new int[arr.length];
        mergeSort(arr, b);
    }

    private void mergeSort(final int[] arr, final int[] b) {
        final int len = arr.length;

        int step = 1;
        while (step < len) {
            final int cnt = (len - 1) / step;
            for (int stepIdx = 0; stepIdx <= cnt; stepIdx += 2) {
                final int beg1 = step * stepIdx;
                final int beg2 = beg1 + step;
                final int end1 = Math.min(beg2, len);
                final int end2 = Math.min(beg2 + step, len);

                int i = beg1;
                int j = beg2;
                int k = i;
                while (i < end1 && j < end2) {
                    if (arr[i] < arr[j]) b[k++] = arr[i++];
                    else b[k++] = arr[j++];
                }
                while (i < end1) b[k++] = arr[i++];
                while (j < end2) b[k++] = arr[j++];

                for (k = beg1; k < end2; k++) arr[k] = b[k];
            }

            step = step * 2;
        }
    }
}
