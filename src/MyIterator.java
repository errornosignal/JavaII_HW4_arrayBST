
import java.util.Iterator;
import java.util.Stack;

class MyIterator<T> extends BST implements Iterator<T>
{
    private Stack<arrayNode<T>> stackAndEggs = new Stack<>();

    /**
     *
     */
    public MyIterator()
    {
        if (root != null)
        {
            stackAndEggs.push(root);
        }
    }

    /**
     *
     * @return
     */
    public boolean hasNext()
    {
        return !stackAndEggs.isEmpty();
    }

    /**
     *
     * @return
     */
    public T next()
    {
        arrayNode<T> current = stackAndEggs.peek();
        if (current.left != null)
        {
            stackAndEggs.push(current.left);
        }
        else
        {
            arrayNode<T> temp = stackAndEggs.pop();
            while (temp.right == null)
            {
                if (stackAndEggs.isEmpty()) return current.data;
                temp = stackAndEggs.pop();
            }
            stackAndEggs.push(temp.right);
        }

        return current.data;
    }

    /**
     *
     */
    public void remove()
    {
        //empty body
        // doNothing();
    }
}