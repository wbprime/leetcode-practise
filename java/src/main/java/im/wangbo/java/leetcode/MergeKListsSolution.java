package im.wangbo.java.leetcode;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class MergeKListsSolution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(final int val) {
            this.val = val;
        }
    }

    private void makeHeap(ListNode[] arr) {
        final int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, len, i);
        }
    }

    private void heapify(ListNode[] arr, int len, int idx) {
        final int l = idx * 2 + 1;
        if (l < len && lessThan(arr[l], arr[idx])) {
            swap(arr, l, idx);
            heapify(arr, len, l);
        }
        final int r = idx * 2 + 2;
        if (r < len && lessThan(arr[r], arr[idx])) {
            swap(arr, r, idx);
            heapify(arr, len, r);
        }
    }

    private boolean lessThan(ListNode a, ListNode b) {
        return a.val < b.val;
    }

    private void swap(ListNode[] arr, int i, int j) {
        ListNode tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;

        final ListNode[] heapArr = new ListNode[len];

        for (int i = 0; i < len; i++) {
            heapArr[i] = lists[i];
        }

        makeHeap(heapArr);

        ListNode head = heapArr[0];

        int left = len;
        ListNode cur = head;
        do {
            ListNode next = cur.next;
            if (null == next) {
                heapArr[0] = heapArr[--left];
            } else {
                heapArr[0] = next;
            }

            heapify(heapArr, left, 0);

            if (left > 0) {
                cur.next = heapArr[0];
                cur = cur.next;
            }
        } while (left > 0);

        return head;
    }
}
