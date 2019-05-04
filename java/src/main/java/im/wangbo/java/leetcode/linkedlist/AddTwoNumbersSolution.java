package im.wangbo.java.leetcode.linkedlist;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/82/
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Elvis Wang
 */
class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
        if (null == l1 || l2 == null) return null;

        ListNode head = new ListNode(0);

        int over = 0;

        ListNode cur = head;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            int v = cur1.val + cur2.val + over;
            over = v / 10;

            cur.next = new ListNode(v % 10);
            cur = cur.next;

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            int v = cur1.val + over;
            over = v / 10;

            cur.next = new ListNode(v % 10);
            cur = cur.next;

            cur1 = cur1.next;
        }

        while (cur2 != null) {
            int v = cur2.val + over;
            over = v / 10;

            cur.next = new ListNode(v % 10);
            cur = cur.next;

            cur2 = cur2.next;
        }

        if (over != 0) {
            cur.next = new ListNode(over);
        }

        return head.next;
    }
}
