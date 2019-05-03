package im.wangbo.java.leetcode.linkedlist;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/44/
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author Elvis Wang
 */
class LinkedListMergeTwoListsSolution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(final int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode lcur = l1;
        ListNode rcur = l2;

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (lcur != null && rcur != null) {
            if (lcur.val < rcur.val) {
                cur.next = lcur;
                lcur = lcur.next;
            } else {
                cur.next = rcur;
                rcur = rcur.next;
            }
            cur = cur.next;
        }

        if (lcur == null) {
            cur.next = rcur;
        }
        if (rcur == null) {
            cur.next = lcur;
        }

        return head.next;
    }
}
