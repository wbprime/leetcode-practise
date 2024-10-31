package im.wangbo.wbprime.leetcode.s20241030;

import com.google.common.primitives.Ints;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

/**
 * TODO add brief description here.
 *
 * @author bwang@citics.com
 * @since 2024-10-31 initial version
 */
public class S2CountOfLongestIncrease {
    static int CASE_IDX = 1;

    public static void main(String[] args) throws IOException {
        {
            final int[] arr = {};
            final int n = 0;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {100, 120};
            final int n = 1;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {120, 110};
            final int n = 0;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {100, 110, 120, 130};
            final int n = 2;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {100, 120, 110, 130};
            final int n = 2;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {100, 120, 130, 110};
            final int n = 1;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {110, 100, 120, 130};
            final int n = 1;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {110, 100, 130, 120};
            final int n = 0;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {120, 110, 100, 130};
            final int n = 1;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {120, 110, 130, 100};
            final int n = 0;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {120, 130, 110, 100};
            final int n = 1;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {130, 120, 110, 100};
            final int n = 0;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {120, 110, 109, 120};
            final int n = 1;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {120, 110, 109, 120, 119, 120};
            final int n = 2;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {120, 110, 109, 120, 119, 120, 121, 115};
            final int n = 2;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {100, 110, 119, 120, 119, 120, 121, 125};
            final int n = 4;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {125, 121, 120, 119, 120, 119, 110, 100};
            final int n = 0;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {100, 110, 80, 90, 60, 70};
            final int n = 3;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {120, 110, 140, 130, 150, 141};
            final int n = 0;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }
        {
            final int[] arr = {120, 110, 130, 140, 150, 141};
            final int n = 1;
            assertEquals(arr, n);
            generateTestData(arr, n);
        }

        final Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int len = r.nextInt(8000) + 1000;
            if (len % 2 != 0) len += 1;

            final int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = r.nextInt(10000) + 100;
            }
            generateTestData(arr, longest_positive_days(arr));
        }
    }

    private static void generateTestData(final int[] arr, final int n) throws IOException {
        final File ifile = new File(String.format("%d.in", CASE_IDX));
        final File ofile = new File(String.format("%d.out", CASE_IDX));
        try (final PrintStream w1 = new PrintStream(ifile); final PrintStream w2 = new PrintStream(ofile)) {
            w1.printf("[%s]%n", Ints.join(",", arr));
            w2.printf("%d%n", n);
        }

        CASE_IDX++;
    }

    private static void assertEquals(final int[] arr, final int n) {
        final int re = longest_positive_days(arr);
        if (n != re) {
            throw new IllegalStateException(String.format("Expect %d but was %d", n, re));
        }
    }

    public static int longest_positive_days(final int[] arr) {
        if (arr.length % 2 != 0)
            throw new IllegalArgumentException("Invalid input");

        int max = 0;

        int cur = 0;
        for (int i = 0; i < arr.length; i += 2) {
            final int even = arr[i];
            final int odd = arr[i + 1];

            if (odd >= even) {
                cur++;
            } else {
                max = Integer.max(max, cur);
                cur = 0;
            }
        }

        return Integer.max(max, cur);
    }
}
