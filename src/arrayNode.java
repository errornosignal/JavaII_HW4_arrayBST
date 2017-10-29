
class arrayNode<T>
{
    public T data;
    public arrayNode<T> left, right;

    /**
     *
     * @param data
     * @param l
     * @param r
     */
    public arrayNode(T data, arrayNode<T> l, arrayNode<T> r)
    {
        left = l; right = r;
        this.data = data;
    }

    /**
     *
     * @param data
     */
    public arrayNode(T data)
    {
        this(data, null, null);
    }

    /**
     *
     * @return
     */
    public String toString()
    {
        return data.toString();
    }
}