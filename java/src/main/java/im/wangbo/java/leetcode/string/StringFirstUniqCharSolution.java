package im.wangbo.java.leetcode.string;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author Elvis Wang
 */
class StringFirstUniqCharSolution {
    public int firstUniqChar(final String s) {
        final int len = s.length();
        if (len == 0) return -1;

        final int[] indices = new int[26];
        for (int i = 0; i < 26; i++) {
            indices[i] = 0;
        }

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                indices[ch - 'a']++;
            }
        }

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (indices[ch - 'a'] == 1) return i;
            }
        }
        return -1;
    }
}

