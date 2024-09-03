/**
 * Goes through different validators to verify if properties of trees are satisfied
 */
public class MaxHeapVerifier {
    /**
     * Initializes an IBinTree object
     */
    private IBinTree someTree;

    /**
     * Initializes an IValidator object
     */
    private IValidator validator;

    /**
     * Initializes a MaxHeapVerifier object
     */
    private MaxHeapVerifier mHV;

    /**
     * Initializes a HeapInvariantValidator object
     */
    private HeapInvariantValidator hIV;

    /**
     * Initializes an ContainsAllValidator object
     */
    private ContainsAllValidator cAV;

    /**
     * Initializes a ContainsElementsValidator object
     */
    private ContainsElementsValidator cEV;

    /**
     * Initializes a boolean for validity of a MaxHeapVerifier
     */
    boolean isValid = mHV.validator.isValid();

    /**
     * Verifies if an after tree (1) is a valid max heap, (2) contains all elements as the before tree,
     * (3) contains the int to be added, and (4) is 1 size larger than the before tree
     * @param IBinTree before, int to be added to tree, IBinTree after
     * @return a boolean
     */
    public boolean verifyAdd(IBinTree before, int added, IBinTree after){
        // check if tree is valid
        //if (after.isValid()) {
          //  return true;
        //}

        // check if all elements before are present after
        //if (after.containsAll) {
          //  return true;
        //}

        // check if added is present in after
        //if (after.contains(added)) {
          //  return true;
        //}

        // check if size of after = size of before + 1
        boolean b = new SizeVisitor(before).getSize() + 1 == new SizeVisitor(after).getSize();
        return b;

    }

    /**
     * Verifies if an after tree (1) is a valid max heap, (2) contains all elements as the before tree,
     * (3) does not contain the root element, and (4) is 1 size smaller than the before tree
     * @param IBinTree before, int to be added to tree, IBinTree after
     * @return a boolean
     */
    public boolean verifyRemoveRoot(IBinTree before, int root, IBinTree after){
        // check if tree is valid

        // check if all elements before are present after

        // check if root is not in after
        //if (!cEV(after).contains(root)) {
          //  return true;
        //}

        // check if size of after = size of before - 1
        boolean b = new SizeVisitor(before).getSize() - 1 == new SizeVisitor(after).getSize();
        return b;
    }
}
