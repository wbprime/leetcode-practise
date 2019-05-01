package im.wangbo.java.leetcode;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class LengthOfLongestSubstringSolution {

    public int lengthOfLongestSubstring(final String s) {
        if (null == s) return 0;

        int len = s.length();

        if (len < 2) return 1;

        int lastLen = 1;

        for (int beg = 0; beg < len; ) {
            int end = beg + 1;

            outer:
            while (end < len) {
                char endChar = s.charAt(end);
                for (int i = beg; i < end; i++) {
                    if (endChar == s.charAt(i)) {
                        int curLen = end - beg;
                        if (curLen > lastLen) {
                            lastLen = curLen;
                        }
                        beg = i + 1;
                        continue outer;
                    }
                }
                end++;
            }

            int curLen = end - beg;
            if (curLen > lastLen) {
                lastLen = curLen;
            }

            break;
        }

        return lastLen;
    }
}
