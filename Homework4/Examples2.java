import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//TESTS FOR IVALIDATOR CLASSES

public class Examples2 {

    @Test
    public void test_ContainsElement() {
        IBinTree someTree = IBinTree.makeTree(new int[]{1,2,3,4,5,6,7});
        assertTrue(new ContainsElementsValidator(3, someTree).isValid());
        assertFalse(new ContainsElementsValidator(9, someTree).isValid());
    }

    @Test
    public void test_biggest1() {
        IBinTree someTree = IBinTree.makeTree(new int[]{1,-2,3,-4,5,-6,7,-8, 9});
        assertTrue(new BiggerThanRestValidator(10, someTree).isValid());
    }

    @Test
    public void test_heapInvariant1() {
        IBinTree goodHeap = IBinTree.makeTree(new int[]{6,4,5,3,2,1});
        IBinTree badHeap = IBinTree.makeTree(new int[]{6,5,4,3,2,1,10});
        assertTrue(new HeapInvariantValidator(goodHeap).isValid());
        assertFalse(new HeapInvariantValidator(badHeap).isValid());
    }

    @Test
    public void test_heapInvariant2() {
        IBinTree heap = IBinTree.makeTree(new int[]{1,-2,3,-4,5,-6,7,-8, 9});
        assertFalse(new HeapInvariantValidator(heap).isValid());
    }

}
