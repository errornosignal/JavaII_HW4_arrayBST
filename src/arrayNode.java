
/**
 * JavaII_HW4_arrayBST
 * arrayNode Class
 * Class for creating an array as a node for use with binary search tree
 * @author Reid Nolan
 * @since 10/29/2017
 * @version 1.0
 * @param <T> <T></T>
 */
class arrayNode<T>
{
    T element;
    arrayNode<T> left, right;

    /**
     * sets left, right, and element to node
     * @param element element
     * @param l l
     * @param r r
     */
    private arrayNode(T element, arrayNode<T> l, arrayNode<T> r)
    {
        left = l; right = r;
        this.element = element;
    }

    /**
     * sets left, right, and element to node
     * @param element element
     */
    arrayNode(T element)
    {
        this(element, null, null);
    }

    /**
     * overrides toString() method in java.lang.Object
     * @return element.toString()
     */
    public String toString()
    {
        return element.toString();
    }
}