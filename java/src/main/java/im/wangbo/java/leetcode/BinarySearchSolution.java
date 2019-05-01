package im.wangbo.java.leetcode;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
class BinarySearchSolution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        // nums is sorted using less-than comparator
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(
            int[] nums, int target,
            int beg,// inclusive
            int end // inclusive
    ) {
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
}
