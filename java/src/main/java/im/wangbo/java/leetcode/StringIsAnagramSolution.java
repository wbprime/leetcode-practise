package im.wangbo.java.leetcode;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/35/
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author Elvis Wang
 */
public class StringIsAnagramSolution {
    public boolean isAnagram(final String s, final String t) {
        final int len = s.length();
        if (len != t.length()) return false;

        if (len == 0) return true;

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
            char ch = t.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                indices[ch - 'a']--;
            }
        }

        for (int index : indices) {
            if (index != 0) return false;
        }
        return true;
    }
}

