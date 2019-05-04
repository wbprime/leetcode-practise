package im.wangbo.java.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/78/
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author Elvis Wang
 */
class LengthOfLongestSubstringSolution {
    public int lengthOfLongestSubstring(final String s) {
        if (null == s) return 0;

        int len = s.length();
        if (len < 2) return len;

        int maxLen = 1;

        final Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < len; i++) {
            int cur = i;
            while (cur < len) {
                char ch = s.charAt(cur++);
                if (set.contains(ch)) {
                    break;
                } else {
                    set.add(ch);
                }
            }

            int curLen = set.size();
            if (curLen > maxLen) {
                maxLen = curLen;
            }

            set.clear();
        }

        return maxLen;
    }
}
