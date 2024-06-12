package im.wangbo.wbprime.leetcode.heapsort


import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class Top10PriceDeviationSolutionSpec extends Specification {
    def test(int[] openPrices, int[] closePrices) {
        given:
        def s = new Top10PriceDeviationSolution()
//        generate()

        and:
        int[] arr = new int[openPrices.length]
        int idx = 0
        for (i in 0..<openPrices.length) {
            int delta = closePrices[i] - openPrices[i]
            if (delta >= -30 && delta <= 30) {
                arr[idx++] = delta
            }
        }
        Arrays.sort(arr, 0, idx)

        int n = Integer.min(10, idx)
        int[] expected = new int[n]
        for (i in 0..<n) {
            expected[i] = arr[idx - i - 1]
        }

        when:
        int[] result = s.topn(openPrices, closePrices)
//        println("$openPrices | $closePrices | $result")

        then:
        result == expected

        where:
        openPrices                                                                                                                        | closePrices
        []                                                                                                                                | []
        [26]                                                                                                                              | [40]
        [26]                                                                                                                              | [178]
        [26, 15]                                                                                                                          | [178, 35]

        [77, 114, 256, 158, 29, 19, 291, 52, 46, 93, 230, 7, 108, 51, 88, 35, 261, 278, 98, 121, 65, 210]                                 | [76, 91, 240, 146, 48, 30, 279, 66, 49, 80, 246, 16, 86, 27, 93, 21, 221, 288, 87, 107, 33, 208]
        [133, 249, 282, 232, 64, 96, 179, 108, 283, 159, 236, 162, 27, 90, 119, 182, 111]                                                 | [111, 249, 297, 251, 24, 73, 154, 125, 262, 123, 228, 131, 10, 84, 92, 197, 114]
        [80, 168, 94, 82, 214, 251, 100, 290, 100, 229, 108, 3]                                                                           | [94, 168, 83, 94, 211, 244, 95, 285, 67, 200, 68, 10]
        [227, 234, 201, 228, 33, 296, 262, 19, 128, 129, 36, 21, 248, 290, 27, 9, 90, 61, 178]                                            | [232, 226, 194, 200, 42, 279, 240, 14, 120, 103, 44, 10, 262, 269, 26, 10, 65, 34, 190]
        [180, 125, 97, 97, 192, 25, 151, 13, 179, 130, 22, 160, 23, 294, 184, 114, 144, 222, 99, 199, 19, 92, 156, 235, 213, 36, 62, 207] | [193, 127, 105, 111, 172, 10, 158, 20, 190, 92, 31, 164, 10, 261, 201, 130, 138, 204, 87, 173, 30, 66, 153, 204, 223, 17, 49, 201]
        [85, 208, 260, 45, 229, 63, 211, 5, 213, 112, 111, 29, 253, 287, 34, 64, 122, 250, 236, 215, 147, 282, 237]                       | [72, 172, 232, 34, 214, 55, 180, 10, 219, 94, 80, 10, 263, 291, 10, 53, 110, 241, 234, 223, 124, 279, 224]
        [38, 172, 107, 243, 291, 293, 125, 68]                                                                                            | [54, 146, 85, 244, 261, 296, 120, 75]
        [249, 109, 267, 135, 176, 240, 279, 237, 225, 76, 239, 119, 13, 24, 203, 180, 219, 147, 206, 131, 286, 69, 74, 65, 80]            | [253, 128, 255, 121, 172, 252, 246, 197, 199, 67, 218, 137, 10, 43, 219, 141, 225, 122, 202, 102, 273, 30, 82, 25, 63]
        [69]                                                                                                                              | [50]
        [155, 80, 236, 239, 242, 100]                                                                                                     | [155, 94, 249, 229, 215, 103]
        [110, 86, 205, 16, 121, 182]                                                                                                      | [117, 69, 222, 10, 108, 160]
    }

    static def generate() {
        Random r = new Random()

        (0..10).each {
            int d = r.nextInt(30) + 1

            int[] buyPrices = new int[d]
            int[] sellPrices = new int[d]

            (0..<d).each {
                buyPrices[it] = r.nextInt(300) + 2
                sellPrices[it] = Integer.max(10, r.nextInt(60) + buyPrices[it] - 40)
            }

            println("$buyPrices | $sellPrices")
        }
    }
}
