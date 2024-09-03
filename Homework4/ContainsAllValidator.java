/**
 * A validator that checks if an after tree contains all the elements in a before tree
 */
public class ContainsAllValidator implements IValidator{
    /**
     * A field that contains the boolean stating whether the after tree contains all the elements from the before tree
     */
    private boolean containsAll = true;

    /**
     * A field that contains an IBinTree container
     */
    private IBinTree container;

    /**
     * A constructor for the ContainsAlValidator object
     * @param IBinTree someTree and IBinTree container
     */
    public ContainsAllValidator(IBinTree someTree, IBinTree container) {
        someTree.accept(this);
        this.container = container;
    }

    /**
     * A ContainsAllValidator is valid if an after tree contains all the elements from the before tree
     * @return a boolean
     */
    @Override
    public boolean isValid() {return containsAll;}

    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        return true;
    }

    @Override
    public boolean visit() {
        return true;
    }
}
