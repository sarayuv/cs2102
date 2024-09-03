/**
 * A validator that checks if a number is bigger than every number in a tree
 */
public class BiggerThanRestValidator implements IValidator{
    /**
     * A field that contains a boolean to initialize the answer to be true by default
     */
    private boolean biggestSoFar = true;

    /**
     * A field that contains the biggest integer
     */
    private int biggest;

    /**
     * A constructor for the BiggerThanRestValidator object
     * @param int number and IBinTree someTree
     */
    public BiggerThanRestValidator(int number, IBinTree someTree) {
        this.biggest = number;
        someTree.accept(this);
    }

    /**
     * A BiggerThanRestValidator is valid if a tree's root element is greater than all elements in its subtree
     * & all of its subtrees are also valid
     * @return a boolean
     */
    @Override
    public boolean isValid() {
        return this.biggestSoFar;
    }

    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        if (data > this.biggest) {
            this.biggestSoFar = false;
            return false;
        }
        return true;
    }

    @Override
    public boolean visit() {
        return true;
    }
}
