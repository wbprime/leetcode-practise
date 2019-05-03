package im.wangbo.java.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author Elvis Wang
 */
class ArrayIntersectionSolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        final Map<Integer, Integer> map = new HashMap<Integer, Integer>(
                len1 < len2 ? len1 : len2
        );

        int[] shortArr = len1 < len2 ? nums1 : nums2;
        int[] longArr = len1 < len2 ? nums2 : nums1;

        for (int val : shortArr) {
            final Integer c = map.get(val);
            if (null != c) map.put(val, c + 1);
            else map.put(val, 1);
        }

        int count = 0;

        for (int val : longArr) {
            final Integer c = map.get(val);
            if (null != c && c > 0) {
                map.put(val, c - 1);
                shortArr[count++] = val;
            }
        }

        final int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = shortArr[i];
        }
        return result;
    }
}
