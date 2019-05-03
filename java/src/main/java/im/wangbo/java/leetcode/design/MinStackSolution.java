package im.wangbo.java.leetcode.design;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class MinStackSolution {
    static class MinStack {
        private final List<Integer> backend = new ArrayList<Integer>();

        private final List<Integer> minIndices = new ArrayList<Integer>();

        public void push(int x) {
            backend.add(x);

            if (minIndices.isEmpty() || x <= backend.get(minIndices.get(minIndices.size() - 1))) {
                minIndices.add(backend.size() - 1);
            }
        }

        public void pop() {
            if (backend.isEmpty()) return;

            final int idx = backend.size() - 1;
            backend.remove(idx);

            if (! minIndices.isEmpty() && idx == minIndices.get(minIndices.size() - 1)) {
                minIndices.remove(minIndices.size() - 1);
            }
        }

        public int top() {
            final int idx = backend.size() - 1;
            return backend.get(idx);
        }

        public int getMin() {
            return backend.get(minIndices.get(minIndices.size() - 1));
        }
    }
}
