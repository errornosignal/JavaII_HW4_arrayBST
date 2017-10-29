
/**
 * JavaII_HW4_arrayBST
 * Tree Interface
 * Interface for binary search tree
 * @author Reid Nolan
 * @since 10/29/2017
 * @version 1.0
 * @param <T> T
 */
public interface Tree<T extends Comparable<? super T>> {
    void insert(T element);
    boolean contains(T element);
    void remove(T element);
}