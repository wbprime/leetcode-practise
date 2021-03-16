package im.wangbo.wbprime.leetcode

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class ListNodes {
    static void print(ListNode l) {
        if (l == null) {
            println("{}")
        } else {
            print("{")
            print(l.val)
            while (l.next != null) {
                print(", ")
                print(l.next.val)

                l = l.next
            }
            println("}")
        }
    }

    static ListNode create(int[] arr) {
        if (arr.length == 0) return null

        ListNode head = new ListNode(arr[0])

        ListNode cur = head
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i])
            cur = cur.next
        }
        return head
    }

    static void assertEquals(ListNode list, int[] arr) {
        assertEquals(list, arr, arr.length)
    }

    static void assertEquals(ListNode list, int[] arr, int len) {
        int n = 0
        while (list != null) {
            assert list.val == arr[n++]
            list = list.next
        }
        assert n == len
    }
}
