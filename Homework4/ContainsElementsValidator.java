/**
 * A validator that checks if a tree contains a specific element
 */
public class ContainsElementsValidator implements IValidator {
    /**
     * A field that contains the integer than is being searched for
     */
    private int lookingFor;

    /**
     * A field that contains the boolean stating whether lookingFor has been found
     */
    private boolean foundIt = false;

    /**
     * A constructor for the ContainsElementsValidator object
     * @param int lookingFor and IBinTree someTree
     */
    public ContainsElementsValidator(int lookingFor, IBinTree someTree) {
        this.lookingFor = lookingFor;
        someTree.accept(this);
    }

    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        if (this.lookingFor == data) {
            foundIt = true;
            return false;
        }
        return true;
    }

    @Override
    public boolean visit() {
        return true;
    }

    /**
     * A ContainsElementValidator is valid if the tree contains the specific element
     * @return a boolean
     */
    @Override
    public boolean isValid() {
        return foundIt;
    }
}
