package im.wangbo.wbprime.leetcode.maxsum;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class MaxProfitSolution {
    public int solve(final int[] arr) {
        if (arr.length > 1) {
            /* index for max item of arr[0] .. arr[i] */
            int maxIdx = 0;
            /* index for min item of arr[0] .. arr[maxIdx] */
            int minIdx = 0;
            /* index for min item of arr[maxIdx] .. arr[i] */
            int newMinIdx = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[maxIdx] <= arr[i]) {
                    maxIdx = i;

                    if (arr[minIdx] > arr[newMinIdx]) {
                        minIdx = newMinIdx;
                        newMinIdx = i;
                    }
                } else {
                    if (arr[newMinIdx] > arr[i]) newMinIdx = i;
                }

                if (arr[i] - arr[newMinIdx] > arr[maxIdx] - arr[minIdx]) {

                }
            }
            return minIdx < maxIdx ? arr[maxIdx] - minIdx : 0;
        } else {
            return 0;
        }
    }

    public int maxSum(final int[] arr) {
        if (arr.length == 0) return 0;

        int sum = 0;
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }

            if (sum > maxSum) maxSum = sum;
        }

        return maxSum;
    }
}
