package im.wangbo.java.leetcode.design;

import java.util.ArrayList;
import java.util.List;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/24/design/59/
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
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
