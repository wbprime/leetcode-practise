package im.wangbo.java.leetcode;

/**
 * TODO add brief description here
 *
 * @author Elvis Wang
 */
public class RemoveDuplicatesSolution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (len == 0) return 0;

        int l = 0;
        int r = l + 1;
        while (l < len) {
            while (r < len && nums[r] == nums[l]) r++;

            if (r == len) break;

            nums[++l] = nums[r++];
        }

        return l + 1;
    }
}
