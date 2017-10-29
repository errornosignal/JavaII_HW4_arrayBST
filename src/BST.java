
import java.util.*;

public class BST <T extends Comparable<T>> implements Iterable<T>
{
    public arrayNode<T> root;
    private Comparator<T> comparator;

    /**
     *
     */
    public BST()
    {
        root = null;
        comparator = null;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    private int compare(T x, T y)
    {
        if (comparator == null) return x.compareTo(y);
        else
            return comparator.compare(x, y);
    }

    /*******************************************************
     *            INSERT
     ******************************************************/
    /**
     *
     * @param data
     */
    public void insert(T data)
    {
        root = insert(root, data);
    }

    /**
     *
     * @param p
     * @param toInsert
     * @return
     */
    private arrayNode<T> insert(arrayNode<T> p, T toInsert)
    {
        if (p == null)
        {
            return new arrayNode<>(toInsert);
        }

        if (compare(toInsert, p.data) == 0)
        {
            return p;
        }

        if (compare(toInsert, p.data) < 0)
        {
            p.left = insert(p.left, toInsert);
        }
        else
        {
            p.right = insert(p.right, toInsert);
        }

        return p;
    }

    /*******************************************************
     *            SEARCH
     ******************************************************/
    /**
     *
     * @param toSearch
     * @return
     */
    public boolean contains(T toSearch)
    {
        return contains(root, toSearch);
    }

    /**
     *
     * @param p
     * @param toSearch
     * @return
     */
    private boolean contains(arrayNode<T> p, T toSearch)
    {
        if (p == null)
        {
            return false;
        }
        else
        {
            if (compare(toSearch, p.data) == 0)
            {
                return true;
            }
            else
            {
                if (compare(toSearch, p.data) < 0)
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

    /*******************************************************
     *            DELETE
     ******************************************************/
    /**
     *
     * @param toRemove
     */
    public void remove(T toRemove)
    {
        root = remove(root, toRemove);
    }

    /**
     *
     * @param p
     * @param toRemove
     * @return
     */
    private arrayNode<T> remove(arrayNode<T> p, T toRemove)
    {
        try
        {
            if (compare(toRemove, p.data) < 0)
            {
                p.left = remove(p.left, toRemove);
            }
            else
            {
                if (compare(toRemove, p.data) > 0)
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
                            // get data from the rightmost node in the left subtree
                            p.data = retrieveData(p.left);
                            // delete the rightmost node in the left subtree
                            p.left = remove(p.left, p.data);
                        }
                    }
                }
            }
            return p;
        }
        catch (RuntimeException REx)
        {
            System.out.println("Cannot remove.");
        }
        return p;
    }

    /**
     *
     * @param p
     * @return
     */
    private T retrieveData(arrayNode<T> p)
    {
        while (p.right != null) p = p.right;

        return p.data;
    }

    /***************************************************
     *            toString
     **************************************************/
    /**
     *
     * @return
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (T data : this)
        {
            sb.append(data.toString());
        }

        return sb.toString();
    }

    /**
     *
     * @return
     */
    public Iterator<T> iterator()
    {
        return new MyIterator();
    }
}