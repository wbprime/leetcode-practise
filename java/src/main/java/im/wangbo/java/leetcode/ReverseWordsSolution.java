package im.wangbo.java.leetcode;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class ReverseWordsSolution {
    public String reverseWords(String s) {
        if (null == s || s.isEmpty()) return s;

        final StringBuilder sb = new StringBuilder("");

        int end = s.length(); // exclusively

        boolean append = false;

        while (end > 0) {
            // trim spaces
            while (end > 0 && s.charAt(end - 1) == ' ') {
                end--;
            }

            if (end == 0) break;

            // find word start
            int beg = end - 1; // inclusively
            while (beg >= 0 && s.charAt(beg) != ' ') {
                beg--;
            }

            if (append) sb.append(' ');

            sb.append(s, beg + 1, end);
            end = beg;

            append = true;
        }

        return sb.toString();
    }
}
