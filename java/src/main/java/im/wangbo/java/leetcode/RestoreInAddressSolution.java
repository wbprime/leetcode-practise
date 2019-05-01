package im.wangbo.java.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class RestoreInAddressSolution {
    public List<String> restoreIpAddresses(String s) {
        if (null == s) return Collections.emptyList();

        final int len = s.length();
        for (int i = 0; i < len; i++) {
            final char a = s.charAt(i);
            if (a > '9' || a < '0') return Collections.emptyList();
        }

        return restoreIpAddresses(s, 0, 4);
    }

    private List<String> restoreIpAddresses(String s, int beg, int count) {
        final int len = s.length() - beg;
        if (count < 1 || len < count || len > 3 * count) return Collections.emptyList();

        final List<String> list = new ArrayList<String>();

        char char0 = s.charAt(beg);
        if (count == 1) {
            if (char0 != '0') {
                if (len > 3) return Collections.emptyList();
                else if (len == 3) {
                    char char1 = s.charAt(beg + 1);
                    if (char0 < '2' ||
                            (char0 == '2' && (char1 < '5' ||
                                    (char1 == '5' && s.charAt(beg + 2) <= '5')
                            )
                            )
                    ) {
                        final String cur = s.substring(beg, beg + 3);
                        return Collections.singletonList(cur);
                    } else {
                        return Collections.emptyList();
                    }
                } else {
                    return Collections.singletonList(s.substring(beg));
                }
            } else {
                if (len == 1) return Collections.singletonList("0");
                else return Collections.emptyList();
            }
        }

        if (char0 == '0') {
            final List<String> l = restoreIpAddresses(s, beg + 1, count - 1);
            for (final String str : l) {
                list.add("0." + str);
            }
        } else {
            {
                final List<String> l = restoreIpAddresses(s, beg + 1, count - 1);
                for (final String str : l) {
                    list.add(char0 + "." + str);
                }
            }

            char char1 = s.charAt(beg + 1);

            {
                final List<String> l = restoreIpAddresses(s, beg + 2, count - 1);
                final String cur = s.substring(beg, beg + 2);
                for (final String str : l) {
                    list.add(cur + "." + str);
                }
            }

            // three chars
            if (len > 2) {
                char char2 = s.charAt(beg + 2);

                if (char0 < '2' || (char0 == '2' && (char1 < '5' || (char1 == '5' && char2 <= '5')))) {
                    final List<String> l = restoreIpAddresses(s, beg + 3, count - 1);
                    final String cur = (s.substring(beg, beg + 3));
                    for (final String str : l) {
                        list.add(cur + "." + str);
                    }
                }
            }

        }

        return list;
    }
}
