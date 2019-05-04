package im.wangbo.java.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/92/
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author Elvis Wang
 */
class GenerateParenthesisSolution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) return Collections.emptyList();

        return privateGenerate(n, n);
    }

    private List<String> privateGenerate(int l, int r) {
        if (l > r) return Collections.emptyList();

        if (l == 0) {
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(')');
            }
            return Collections.singletonList(sb.toString());
        }

        final List<String> list = new ArrayList<>();
        if (l > 0) {
            List<String> subList = privateGenerate(l - 1, r);

            for (String s : subList) {
                list.add('(' + s);
            }
        }

        if (r > 0) {
            List<String> subList = privateGenerate(l, r - 1);

            for (String s : subList) {
                list.add(')' + s);
            }
        }

        return list;
    }
}
