/**
 * A validator that checks if, in a tree, a node's element is smaller than an element on one of its child nodes
 */
public class HeapInvariantValidator implements IValidator{
    /**
     * A field that contains the boolean stating whether the tree is valid
     */
    public boolean valid = true;

    /**
     * A constructor for the HeapInvariantValidator object
     * @param IBinTree someTree
     */
    public HeapInvariantValidator(IBinTree someTree) {
        someTree.accept(this);
    }

    /**
     * A HeapInvariantValidator is valid if a tree does not have any node's
     * elements being smaller than one of its child nodes
     * @return a boolean
     */
    @Override
    public boolean isValid() {
        return this.valid;
    }

    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        if (! new BiggerThanRestValidator(data, left).isValid()) {
            this.valid = false;
            return false;
        }
        if (! new BiggerThanRestValidator(data, right).isValid()) {
            this.valid = false;
            return false;
        }
        return true;
    }

    @Override
    public boolean visit() {
        return true;
    }
}
