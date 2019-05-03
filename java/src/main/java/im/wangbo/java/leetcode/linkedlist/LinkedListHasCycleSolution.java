package im.wangbo.java.leetcode.linkedlist;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/46/
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *      [3] -> [2] -> [0] -> [-4] -|
 *              ^- <- <- <- <- <- -|
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *      [1] -> [2] -|
 *       ^- <- <- <-|
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *      [1] -> null
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @author Elvis Wang
 */
class LinkedListHasCycleSolution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(final int val) {
            this.val = val;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (null == head || null == head.next) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        return slow == fast;
    }
}
