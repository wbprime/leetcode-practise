package im.wangbo.wbprime.leetcode.binarytree

import im.wangbo.wbprime.leetcode.TreeNode
import spock.lang.Specification

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class TreeTraverseSolutionSpec extends Specification {
    def "test in order traverse"() {
        given:
        def s = new TreeTraverseSolution()

        def root = new TreeNode(3)
        def l1 = new TreeNode(1)
        def l2 = new TreeNode(4)
        root.left = l1
        root.right = l2
        def l3 = new TreeNode(2)
        def l4 = new TreeNode(5)
        l1.left = l3
        l1.right = l4
        def l5 = new TreeNode(6)
        def l6 = new TreeNode(11)
        l2.left = l5
        l2.right = l6
        def l7 = new TreeNode(7)
        l4.left = l7
        def l8 = new TreeNode(9)
        l5.right = l8
        def l9 = new TreeNode(12)
        def l10 = new TreeNode(15)
        l6.left = l9
        l6.right = l10

        int[] expected = [2, 1, 7, 5, 3, 6, 9, 4, 12, 11, 15,]

        when:
        def result = s.inOrder(root)

        then:
        result == expected
    }

    def "test pre order traverse"() {
        given:
        def s = new TreeTraverseSolution()

        def root = new TreeNode(3)
        def l1 = new TreeNode(1)
        def l2 = new TreeNode(4)
        root.left = l1
        root.right = l2
        def l3 = new TreeNode(2)
        def l4 = new TreeNode(5)
        l1.left = l3
        l1.right = l4
        def l5 = new TreeNode(6)
        def l6 = new TreeNode(11)
        l2.left = l5
        l2.right = l6
        def l7 = new TreeNode(7)
        l4.left = l7
        def l8 = new TreeNode(9)
        l5.right = l8
        def l9 = new TreeNode(12)
        def l10 = new TreeNode(15)
        l6.left = l9
        l6.right = l10

        int[] expected = [3, 1, 2, 5, 7, 4, 6, 9, 11, 12, 15]

        when:
        def result = s.preOrder(root)

        then:
        result == expected
    }

    def "test post order traverse"() {
        given:
        def s = new TreeTraverseSolution()

        def root = new TreeNode(3)
        def l1 = new TreeNode(1)
        def l2 = new TreeNode(4)
        root.left = l1
        root.right = l2
        def l3 = new TreeNode(2)
        def l4 = new TreeNode(5)
        l1.left = l3
        l1.right = l4
        def l5 = new TreeNode(6)
        def l6 = new TreeNode(11)
        l2.left = l5
        l2.right = l6
        def l7 = new TreeNode(7)
        l4.left = l7
        def l8 = new TreeNode(9)
        l5.right = l8
        def l9 = new TreeNode(12)
        def l10 = new TreeNode(15)
        l6.left = l9
        l6.right = l10

        int[] expected = [2, 7, 5, 1, 9, 6, 12, 15, 11, 4, 3]

        when:
        def result = s.postOrder(root)

        then:
        result == expected
    }

    def "test level order traverse"() {
        given:
        def s = new TreeTraverseSolution()

        def root = new TreeNode(3)
        def l1 = new TreeNode(1)
        def l2 = new TreeNode(4)
        root.left = l1
        root.right = l2
        def l3 = new TreeNode(2)
        def l4 = new TreeNode(5)
        l1.left = l3
        l1.right = l4
        def l5 = new TreeNode(6)
        def l6 = new TreeNode(11)
        l2.left = l5
        l2.right = l6
        def l7 = new TreeNode(7)
        l4.left = l7
        def l8 = new TreeNode(9)
        l5.right = l8
        def l9 = new TreeNode(12)
        def l10 = new TreeNode(15)
        l6.left = l9
        l6.right = l10

        int[] expected = [3, 1, 4, 2, 5, 6, 11, 7, 9, 12, 15]

        when:
        def result = s.levelOrder(root)

        then:
        result == expected
    }

    def "test alternate level order traverse"() {
        given:
        def s = new TreeTraverseSolution()

        def root = new TreeNode(3)
        def l1 = new TreeNode(1)
        def l2 = new TreeNode(4)
        root.left = l1
        root.right = l2
        def l3 = new TreeNode(2)
        def l4 = new TreeNode(5)
        l1.left = l3
        l1.right = l4
        def l5 = new TreeNode(6)
        def l6 = new TreeNode(11)
        l2.left = l5
        l2.right = l6
        def l7 = new TreeNode(7)
        l4.left = l7
        def l8 = new TreeNode(9)
        l5.right = l8
        def l9 = new TreeNode(12)
        def l10 = new TreeNode(15)
        l6.left = l9
        l6.right = l10

        int[] expected = [3, 1, 4, 11, 6, 5, 2, 7, 9, 12, 15]

        when:
        def result = s.alternateLevelOrder(root)

        then:
        result == expected
    }
}
