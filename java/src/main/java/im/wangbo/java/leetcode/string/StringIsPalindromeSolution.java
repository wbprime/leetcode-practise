package im.wangbo.java.leetcode.string;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/36/
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * @author Elvis Wang
 */
public class StringIsPalindromeSolution {
    public boolean isPalindrome(final String s) {
        final int len = s.length();
        if (len <= 1) return true;

        int l = 0;
        int r = len - 1;
        while (l < r) {
            while (l < r && skipsChar(s.charAt(l))) l++;
            while (l < r && skipsChar(s.charAt(r))) r--;

            if (l >= r) break;

            if (equalsChar(s.charAt(l), s.charAt(r))) {
                l++;
                r--;
            } else {
                break;
            }
        }

        return r <= l;
    }

    private boolean equalsChar(char ch1, char ch2) {
        if (ch1 == ch2) return true;

        int tmp1;
        int tmp2;

        if (ch1 >= 'a' && ch1 <= 'z') tmp1 = ch1 - 'a';
        else if (ch1 >= 'A' && ch1 <= 'Z') tmp1 = ch1 - 'A';
        else tmp1 = -1;

        if (ch2 >= 'a' && ch2 <= 'z') tmp2 = ch2 - 'a';
        else if (ch2 >= 'A' && ch2 <= 'Z') tmp2 = ch2 - 'A';
        else tmp2 = -2;

        return tmp1 == tmp2;
    }

    private boolean skipsChar(char ch) {
        return !((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'));
    }
}

