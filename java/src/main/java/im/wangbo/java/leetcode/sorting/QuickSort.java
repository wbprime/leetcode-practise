package im.wangbo.java.leetcode.sorting;

/**
 * @author Elvis Wang
 */
class QuickSort {
    public int[] sort(int [] arr) {
        if (null == arr || arr.length <= 1) return arr;

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int [] arr, int beg, int end) {
        if (beg < end) {
            int pivot = partition(arr, beg, end);
            quickSort(arr, beg, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private int partition(int [] arr, int beg, int end) {
        int tmp = arr[beg];
        while (beg < end) {
            while (end > beg && arr[end] >= tmp) end --;

            if (end > beg) arr[beg++] = arr[end];

            while (end >beg && arr[beg] <= tmp) beg++;

            if (end > beg) arr[end --] = arr[beg];
        }
        arr[end] = tmp;

        return end;
    }
}
