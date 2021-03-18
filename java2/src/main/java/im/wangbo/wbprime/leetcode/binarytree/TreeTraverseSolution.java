package im.wangbo.wbprime.leetcode.binarytree;

import im.wangbo.wbprime.leetcode.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
public class TreeTraverseSolution {
    private static final int[] EMPTY = {};

    private static int[] traverse(
        final TreeNode root, final BiConsumer<TreeNode, IntConsumer> traverser
    ) {
        if (root == null) return EMPTY;

        final AtomicInteger n = new AtomicInteger();

        {
            final IntConsumer c = _v -> n.getAndIncrement();
            traverser.accept(root, c);
        }

        final int[] result = new int[n.get()];
        {
            n.set(0);
            final IntConsumer c = _v -> {
                final int idx = n.getAndIncrement();
                result[idx] = _v;
            };
            traverser.accept(root, c);
        }

        return result;
    }

    public int[] inOrder(final TreeNode root) {
        final InOrderTraverse traverse = new InOrderTraverse();
        return traverse(root, traverse::traverse);
    }

    public int[] preOrder(final TreeNode root) {
        final PreOrderTraverse traverse = new PreOrderTraverse();
        return traverse(root, traverse::traverse);
    }

    public int[] postOrder(final TreeNode root) {
        final PostOrderTraverse traverse = new PostOrderTraverse();
        return traverse(root, traverse::traverse);
    }

    public int[] levelOrder(final TreeNode root) {
        final LevelOrderTraverse traverse = new LevelOrderTraverse();
        return traverse(root, traverse::traverse);
    }

    public int[] alternateLevelOrder(final TreeNode root) {
        final AlternateLevelOrderTraverse traverse = new AlternateLevelOrderTraverse();
        return traverse(root, traverse::traverse);
    }
}
