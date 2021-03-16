package im.wangbo.wbprime.leetcode
/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class ArrayDatas {
    static int randomValue() {
        final Random r = new Random();
        return r.nextInt();
    }

    static int randomValue(int lowerInclusive, int upperExclusive) {
        final Random r = new Random();
        return r.nextInt(upperExclusive - lowerInclusive) + lowerInclusive;
    }

    static int[] random(int size, int lowerInclusive, int upperExclusive) {
        if (size <= 0) return new int[]{};

        final int[] arr = new int[size];
        final Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(upperExclusive - lowerInclusive) + lowerInclusive;
        }
        return arr;
    }

    static int[] random(int size) {
        if (size <= 0) return new int[]{};

        final int[] arr = new int[size];
        final Random r = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt();
        }
        return arr;
    }

    static int[][] random(int row, int maxCol, int lowerInclusive, int upperExclusive) {
        if (row <= 0) return new int[0][]

        def result = new int[row][]
        final Random r = new Random()

        for (int i = 0; i < row; i++) {
            final int col = maxCol <= 0 ? 0 : r.nextInt(maxCol)
            final int[] arr = col <= 0 ? new int[]{} : new int[col];
            for (int j = 0; j < col; j++) arr[j] = r.nextInt(upperExclusive) + lowerInclusive;
            result[i] = arr;
        }

        return result;
    }

    static void assertSorted(final int[] arr) {
        if (arr.length < 2) return

        for (int i = 1; i < arr.length; i++) {
            assert arr[i - 1] <= arr[i]
        }
    }
}
