
import java.util.*;

/**
 * JavaII_HW4_arrayBST
 * Main Class
 * Class for testing contains() and removes() methods on an array-based binary search tree
 * @author Reid Nolan
 * @since 10/29/2017
 * @version 1.0
 *
 */
public class Main
{
    /**
     * tests contains and removes methods on array-based binary search tree
     * @param args args
     */
    public static void main(String[] args)
    {
        //program header
        System.out.println("JavaII_HW4_arrayBST" + "\n");

        //define constants
        final int kTO_GENERATE = 200000;
        final int kTO_ADD = 100000;

        //generate numberList
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = kTO_GENERATE; i > 0; i--)
        {
            numberList.add(i);
        }

        //shuffle numberList
        Collections.shuffle(numberList);

        //add 1st few values to binarySearchTree
        BST<Integer> bst = new BST<>();
        for(int i = 0; i < kTO_ADD; i++)
        {
            bst.insert(numberList.get(i));
        }

        //test contains method
        System.out.println("Tree contains 5: " + bst.contains(5));
        System.out.println("Tree contains 90000: " + bst.contains(90000));
        System.out.println();

        //test remove method
        System.out.println("Running remove method...");
        bst.remove(5);

        //verify remove method works and contains reports accurately
        System.out.println();
        System.out.println("Tree contains 5: " + bst.contains(5));
        System.out.println("Tree contains 90000: " + bst.contains(90000));
    }
}