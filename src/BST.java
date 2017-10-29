
import java.util.*;

/**
 * JavaII_HW4_arrayBST
 * BST Class
 * Class for binary search tree operations
 * @author Reid Nolan
 * @since 10/29/2017
 * @version 1.0
 * @param <T> T
 *
 */
public class BST <T extends Comparable<? super T>> implements Tree<T>
{
    private arrayNode<T> root;
    private Comparator<T> comparator;

    /**
     * sets root and comparator to null
     */
    public BST()
    {
        root = null;
        comparator = null;
    }

    /**
     * compares two elements
     * @param x x
     * @param y y
     * @return comparator.compare(x, y)
     */
    private int compare(T x, T y)
    {
        if (comparator == null)
        {
            return x.compareTo(y);
        }
        else
        {
            return comparator.compare(x, y);
        }
    }

    /**
     * inserts a value into binary search tree
     * @param element element
     */
    @Override
    public void insert(T element)
    {
        root = insert(root, element);
    }

    /**
     * inserts a value into binary search tree
     * @param p p
     * @param toInsert toInsert
     * @return new arrayNode (toInsert) / p
     */
    private arrayNode<T> insert(arrayNode<T> p, T toInsert)
    {
        if (p == null)
        {
            return new arrayNode<>(toInsert);
        }
        else
        {
            if (compare(toInsert, p.element) == 0)
            {
                return p;
            }
            else
                if (compare(toInsert, p.element) < 0)
                {
                    p.left = insert(p.left, toInsert);
                }
                else
                {
                    p.right = insert(p.right, toInsert);
                }
        }
        return p;
    }

    /**
     * determines if a value exists in binary search tree
     * @param toSearch toSearch
     * @return contains(root, toSearch)
     */
    public boolean contains(T toSearch)
    {
        return contains(root, toSearch);
    }

    /**
     * determines if a value exists in binary search tree
     * @param p p
     * @param toSearch toSearch
     * @return false / true / contains(p.left, toSearch) / contains(p.right, toSearch)
     */
    private boolean contains(arrayNode<T> p, T toSearch)
    {
        if (p == null)
        {
            return false;
        }
        else
        {
            if (compare(toSearch, p.element) == 0)
            {
                return true;
            }
            else
            {
                if (compare(toSearch, p.element) < 0)
                {
                    return contains(p.left, toSearch);
                }
                else
                {
                    return contains(p.right, toSearch);
                }
            }
        }
    }

    /**
     * removes a value in binary search tree
     * @param toRemove toRemove
     */
    public void remove(T toRemove)
    {
        root = remove(root, toRemove);
    }

    /**
     * removes a value in binary search tree
     * @param p p
     * @param toRemove toRemove
     * @return p.right / p.left / p
     */
    private arrayNode<T> remove(arrayNode<T> p, T toRemove)
    {
        try
        {
            if (compare(toRemove, p.element) < 0)
            {
                p.left = remove(p.left, toRemove);
            }
            else
            {
                if (compare(toRemove, p.element) > 0)
                {
                    p.right = remove(p.right, toRemove);
                }
                else
                {
                    if (p.left == null)
                    {
                        return p.right;
                    }
                    else
                    {
                        if (p.right == null)
                        {
                            return p.left;
                        }
                        else
                        {
                            p.element = retrieveElement(p.left);
                            p.left = remove(p.left, p.element);
                        }
                    }
                }
            }
            return p;
        }
        catch (RuntimeException REx)
        {
            System.out.println("RuntimeException! Cannot remove value.");
        }
        return p;
    }

    /**
     * gets element from node
     * @param p p
     * @return p.element
     */
    private T retrieveElement(arrayNode<T> p)
    {
        while (p.right != null)
        {
            p = p.right;
        }
        return p.element;
    }
}