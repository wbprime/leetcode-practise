package im.wangbo.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class MinStackSolution {
    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int x) {
            this.val = x;
            this.prev = null;
            this.next = null;
        }
    }

    static class MinStack {

        private final Node first = new Node(0);

        private final List<Node> backend = new ArrayList<>();

        public void push(int x) {
            final Node n = new Node(x);

            Node cur = first;
            Node next = cur.next;
            while (null != next && next.val < x) {
                cur = next;
                next = cur.next;
            }
            n.prev = cur;
            if (null != next) {
                next.prev = n;
                n.next = next;
            }
            cur.next = n;

            backend.add(n);
        }

        public void pop() {
            if (backend.isEmpty()) return;

            final Node n = backend.get(backend.size() - 1);

            final Node prev = n.prev;
            final Node next = n.next;
            if (null != prev) {
                prev.next = next;
            }
            if (null != next) {
                next.prev = prev;
            }

            backend.remove(backend.size() - 1);
        }

        public int top() {
            final Node n = backend.get(backend.size() - 1);
            return n.val;
        }

        public int getMin() {
            return first.next.val;
        }
    }
}
