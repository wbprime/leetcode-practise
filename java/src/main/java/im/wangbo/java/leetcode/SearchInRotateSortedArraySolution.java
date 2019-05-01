package im.wangbo.java.leetcode;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class SearchInRotateSortedArraySolution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        return privateSearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int beg, int end) {
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return -1;
    }

    private int privateSearch(int[] nums, int target, int beg, int end) {
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[beg]) {
                // left part is sorted
                if (nums[beg] <= target && nums[mid] > target) {
                    return binarySearch(nums, target, beg, mid - 1);
                } else if (nums[mid] > target && nums[end] < target) {
                    return -1;
                } else {
                    beg = mid + 1;
                }
            } else {
                // right part is sorted
                if (nums[end] >= target && nums[mid] < target) {
                    return binarySearch(nums, target, mid + 1, end);
                } else if (nums[mid] < target && nums[beg] > target) {
                    return -1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
