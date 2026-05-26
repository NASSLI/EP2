/**
 * Iterable wrapper node used for traversing only nodes at level 2
 * of a {@link PhysicalPhysicalTreeMap}.
 *
 * <p>This class wraps a {@link PhysicalPhysicalTreeMapNode} so that it can
 * be processed by a {@link PhysicalTreeIterator}.</p>
 *
 * <p>The traversal order is identical to the traversal order of the
 * corresponding tree map iterator.</p>
 *
 * <p>Only keys stored in nodes at level 2 are returned by the traversal.
 * Nodes at other levels are traversed in order to continue the traversal,
 * but their associated keys are not returned.</p>
 *
 * <p>The root node is considered to be at level 0.</p>
 *
 * <p>The traversal is performed lazily. No additional data structure
 * containing all matching keys is created in advance.</p>
 */
public class PhysicalPhysicalTreeMapLevelTwoIterableNode
        implements PhysicalIterableTreeNode {

    private PhysicalPhysicalTreeMapNode node;
    private int level;

    /**
     * Creates a new iterable wrapper for the specified tree map node.
     *
     * @param node  the wrapped tree map node; {@code node != null}
     * @param level the level of the wrapped node within the tree;
     *              the root node is at level {@code 0}
     */
    public PhysicalPhysicalTreeMapLevelTwoIterableNode(
            PhysicalPhysicalTreeMapNode node, int level) {
        this.level = level;
        this.node = node;

    }

    /**
     * Updates the traversal state at this node and may return the next
     * key stored in a node at level 2.
     *
     * <p>This implementation traverses the tree in the same order as the
     * corresponding tree map iterator (obtained by {@code iterator()}).</p>
     *
     * <p>If {@code next == false}, the traversal structure is initialized
     * by inserting nodes into the iterator.</p>
     *
     * <p>If {@code next == true}, traversal continues with the remaining
     * subtree. If the wrapped node is located at level 2, its associated
     * key is returned. Otherwise, traversal continues without returning
     * an element from this node.</p>
     *
     * @param iterator the iterator whose traversal state may be extended;
     *                 {@code iterator != null}
     * @param next     indicates whether this is a continuation step
     *                 of a previously scheduled node
     * @return the next key stored in a node at level 2,
     * or {@code null} if this call only updates the traversal state
     */
    @Override
    public Physical iter(PhysicalTreeIterator iterator, boolean next) {
        if (!next) {
            new PhysicalTreeIterator(this, iterator);
            if (node.getRight() != null) {
                new PhysicalPhysicalTreeMapLevelTwoIterableNode(node.getRight(), level + 1).iter(iterator, false);
            }
            return null;
        }
        if (node.getLeft() != null) {
            new PhysicalPhysicalTreeMapLevelTwoIterableNode(node.getLeft(), level + 1).iter(iterator, false);
        }
        if (level == 2) {
            return node.getKey();
        }
        return iterator.next();
    }
}