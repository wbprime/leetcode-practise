package im.wangbo.java.leetcode.others;

import java.util.ArrayList;
import java.util.List;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/68/
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @author Elvis Wang
 */
class ValidBracketSolution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len <= 0) return true;

        final List<Character> stack = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            final char ch = s.charAt(i);

            switch (ch) {
                case '(': // fall through
                case '{': // fall through
                case '[':
                    stack.add(ch);
                    break;
                case ')': {
                    if (stack.isEmpty() || stack.remove(stack.size() - 1) != '(') return false;
                }
                break;
                case '}': {
                    if (stack.isEmpty() || stack.remove(stack.size() - 1) != '{') return false;
                }
                break;
                case ']': {
                    if (stack.isEmpty() || stack.remove(stack.size() - 1) != '[') return false;
                }
                break;
                default: // Do nothing
            }
        }

        return stack.isEmpty();
    }
}
