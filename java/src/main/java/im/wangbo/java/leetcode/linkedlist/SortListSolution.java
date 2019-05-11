package im.wangbo.java.leetcode.linkedlist;

/**
 * See https://leetcode-cn.com/problems/sort-list/
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author Elvis Wang
 */
class SortListSolution {
    public ListNode sortList(final ListNode head) {
        if (null == head || head.next == null) return head;

        return mergeSort(head);
    }

    public ListNode mergeSort(final ListNode head) {
        if (head == null) return head;

        ListNode preSlow = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (null == preSlow) return head;
        preSlow.next = null;

        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(slow);
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return result.next;
    }
}
