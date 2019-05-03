package im.wangbo.java.leetcode.design;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class MinStackSolutionTest {
    @Test
    void test() {
        final MinStackSolution.MinStack minStack = new MinStackSolution.MinStack();

        minStack.push(-2);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        {
            final int result = minStack.getMin(); // -- > 返回 -3.
            Assertions.assertThat(result).isEqualTo(-3);
        }
        minStack.pop();
        {
            final int result = minStack.top();      // --> 返回 0.
            Assertions.assertThat(result).isEqualTo(0);
        }
        {
            final int result = minStack.getMin(); // -- > 返回 -2.
            Assertions.assertThat(result).isEqualTo(-2);
        }
    }
}