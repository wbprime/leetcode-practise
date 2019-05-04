package im.wangbo.java.leetcode.string;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/79/
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author Elvis Wang
 */
class LongestPalindromeSolution {
    public String longestPalindrome(final String s) {
        if (null == s || s.length() < 2) return s;

        int len = s.length();

        int lastBeg = 0;
        int lastEnd = lastBeg;
        for (int i = 0; i < len; i++) {
            {
                int curBeg = i - 1;
                int curEnd = i + 1;
                while (curBeg >= 0 && curEnd < len && s.charAt(curBeg) == s.charAt(curEnd)) {
                    curBeg--;
                    curEnd++;
                }

                curBeg ++;
                curEnd --;
                if (curEnd - curBeg > lastEnd - lastBeg) {
                    lastBeg = curBeg;
                    lastEnd = curEnd;
                }
            }
            {
                int curBeg = i;
                int curEnd = i + 1;
                while (curBeg >= 0 && curEnd < len && s.charAt(curBeg) == s.charAt(curEnd)) {
                    curBeg--;
                    curEnd++;
                }

                curBeg ++;
                curEnd --;
                if (curEnd - curBeg > lastEnd - lastBeg) {
                    lastBeg = curBeg;
                    lastEnd = curEnd;
                }
            }
        }

        return s.substring(lastBeg, lastEnd + 1);
    }
}
