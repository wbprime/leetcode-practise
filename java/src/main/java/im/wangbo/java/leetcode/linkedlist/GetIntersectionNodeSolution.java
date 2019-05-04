package im.wangbo.java.leetcode.linkedlist;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/84/
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *  a1 -> a2 - - -> c1 -> c2 -> c3
 *  b1 -> b2 -> b3 /
 *
 * 在节点 c1 开始相交。
 *
 * More description omitted.
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author Elvis Wang
 */
class GetIntersectionNodeSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA) return null;
        if (null == headB) return null;

        // Temporarily change list a to be a whole cycle
        ListNode tmp = headA;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        final ListNode end = tmp;
        end.next = headA;

        ListNode meet = hasCycle(headB);
        if (meet == null) {
            end.next = null;
            return null;
        }

        tmp = headB;
        while (tmp != meet) {
            tmp = tmp.next;
            meet = meet.next;
        }

        end.next = null;
        return tmp;
    }

    private ListNode hasCycle(final ListNode head) {
        if (head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        return slow == fast ? slow : null;
    }
}
