package im.wangbo.java.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/93/
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author Elvis Wang
 */
class PermuteSolution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();

        return recursivePermute(nums, nums.length - 1);
    }

    private List<List<Integer>> recursivePermute(int[] nums, int end) {
        final List<List<Integer>> permList = new ArrayList<>();
        if (end == 0) {
            final List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[end]);
            permList.add(tmp);
        } else {
            for (int i = 0; i <= end; i++) {
                swap(nums, i, end);

                final List<List<Integer>> list = recursivePermute(nums, end - 1);
                for (List<Integer> tmp : list) {
                    tmp.add(nums[end]);
                    permList.add(tmp);
                }

                swap(nums, i, end);
            }
        }
        return permList;
    }

    private void swap(final int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<List<Integer>> permute2(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        final List<List<Integer>> list = new ArrayList<>();

        do {
            final List<Integer> l = new ArrayList<>(nums.length);
            for (int num : nums) {
                l.add(num);
            }

            list.add(l);
        } while (nextPermutation(nums));

        return list;
    }

    private boolean nextPermutation(int[] nums) {
        int idx = nums.length - 1;
        while (idx > 0 && nums[idx - 1] >= nums[idx]) {
            idx--;
        }

        if (idx == 0) return false;

        int swapIdx = nums.length - 1;
        while (swapIdx > idx - 1 & nums[swapIdx] <= nums[idx - 1]) swapIdx--;

        if (swapIdx > idx - 1) {
            swap(nums, idx - 1, swapIdx);

            int beg = idx;
            int end = nums.length - 1;
            while (beg < end) {
                swap(nums, beg++, end--);
            }

            return true;
        } else {
            return false;
        }
    }
}
