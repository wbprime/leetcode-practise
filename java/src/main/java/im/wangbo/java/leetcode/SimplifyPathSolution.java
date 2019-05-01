package im.wangbo.java.leetcode;

import java.util.Stack;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class SimplifyPathSolution {
    public String simplifyPath(final String path) {
        final Stack<String> parts = new Stack<>();

        int len = path.length();

        int beg = 0;
        while (beg < len) {
            while (beg < len && path.charAt(beg) == '/') {
                beg++;
            }

            if (beg == len) break;

            int end = beg + 1;
            while (end < len && path.charAt(end) != '/') {
                end++;
            }

            final String str = path.substring(beg, end);
            if (".".equals(str)) {
                // Do nothing
            } else if ("..".equals(str)) {
                if (!parts.isEmpty()) parts.pop();
            } else {
                parts.push(str);
            }

            beg = end + 1;
        }

        final StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            sb.append("/").append(part);
        }

        final String result = sb.toString();
        return result.isEmpty() ? "/" : result;
    }
}
