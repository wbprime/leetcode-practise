package im.wangbo.java.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author Elvis Wang
 */
class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        if (strs.length == 0) return Collections.emptyList();

        final HashMap<String, List<String>> cache = new HashMap<>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }

            final String key = new String(arr);
            final List<String> list = cache.get(key);
            if (list != null) {
                list.add(str);
            } else {
                final List<String> tmp = new ArrayList<>();
                tmp.add(str);
                cache.put(key, tmp);
            }
        }

        final List<List<String>> result = new ArrayList<>(cache.size());
        for (Map.Entry<String, List<String>> entry : cache.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
