package im.wangbo.java.leetcode.linkedlist;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/45/
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author Elvis Wang
 */
class LinkedListIsPalindromeSolution {
    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // new slow is the mid node
        // head -> slow
        // slow -> null

        // try to reverse the latter half: mid to null

        ListNode rear = reverse(slow);
        ListNode l = head, r = rear;
        while (l != null && r != null && l.val == r.val) {
            l = l.next;
            r = r.next;
        }

        boolean result = l == null || r == null;

        reverse(rear);

        return result;
    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node;
        ListNode next = cur.next;
        while (next != null) {
            ListNode nnext = next.next;

            next.next = cur;
            cur = next;
            next = nnext;
        }
        node.next = null;

        return cur;
    }
}
