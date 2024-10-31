package im.wangbo.wbprime.leetcode.s20241030;

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
public class S1ParseHexString {
    static int CASE_IDX = 1;

    public static void main(String[] args) throws IOException {
        final Random r = new Random();
        generateTestData(11);
        for (int i = 0; i < 14; i++) {
            assertEquals(i);
            generateTestData(i);
            assertEquals((long) i + 0x8012ABcdL);
            generateTestData((long) i + 0x8012ABcdL);

            final long ll = Math.abs(r.nextLong());
            assertEquals(ll);
            generateTestData(ll);
        }
    }

    private static void generateTestData(final long ll) throws IOException {
        final File ifile = new File(String.format("%d.in", CASE_IDX));
        final File ofile = new File(String.format("%d.out", CASE_IDX));
        try (final PrintStream w1 = new PrintStream(ifile); final PrintStream w2 = new PrintStream(ofile)) {
            if (ll % 2 == 0) w1.printf("\"%X\"%n", ll);
            else w1.printf("\"%x\"%n", ll);
            w2.printf("%d%n", ll);
        }

        CASE_IDX++;
    }

    private static void assertEquals(final long ll) {
        final String str = Long.toHexString(ll);

        final long re = parse_hex(str);
        if (ll != re) {
            throw new IllegalStateException(String.format("Expect to parse \"%s\" as %d but was %d", str, ll, re));
        }
    }

    public static long parse_hex(final String str) {
        if (str.isEmpty())
            throw new IllegalArgumentException(String.format("Invalid input \"%s\"", str));

        long result = 0;

        for (int i = 0, n = str.length(); i < n; i++) {
            final char ch = str.charAt(i);
            switch (ch) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': {
                    result *= 16L;
                    result += (ch - '0');
                    break;
                }
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F': {
                    result *= 16L;
                    result += 10L;
                    result += (ch - 'A');
                    break;
                }
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f': {
                    result *= 16L;
                    result += 10L;
                    result += (ch - 'a');
                    break;
                }
                default:
                    throw new IllegalArgumentException(String.format("Invalid input \"%s\" at pos=%d", str, i));
            }
        }

        return result;
    }
}
