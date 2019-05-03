package im.wangbo.java.leetcode.sorting;

import sun.plugin2.ipc.InProcEvent;

import java.util.function.IntPredicate;

/**
 * See https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/53/
 *
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。
 *
 * @author Elvis Wang
 */
class FirstBadVersionSolution {
    // To verify this solution, set this field to the target value
    static int TARGET = 0;

    // Mocked method
    boolean isBadVersion(int version) {
        return version >= TARGET;
    }

    public int firstBadVersion(int n) {
        int beg = 0;
        int end = n;

        while (beg < end) {
            int mid = beg + (end - beg) / 2;
            if (isBadVersion(mid)) {
                if (beg == mid) break;

                end = mid;
            } else {
                beg = mid + 1;
            }
        }

        return beg;
    }
}
