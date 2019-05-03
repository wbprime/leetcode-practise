package im.wangbo.java.leetcode.linkedlist;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/43/
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author Elvis Wang
 */
class LinkedListReverseListSolution {
    public ListNode reverseList(final ListNode head) {
        if (null == head || head.next == null) return head;

        ListNode cur = head;
        ListNode next = cur.next;
        cur.next = null;
        while (null != next) {
            ListNode nnext = next.next;

            next.next = cur;
            cur = next;
            next = nnext;
        }

        return cur;
    }
}
