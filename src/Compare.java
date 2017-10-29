
import java.util.Comparator;

class MyComp1 implements Comparator<Integer>
{
    public int compare(Integer x, Integer y)
    {
        return x-y;
    }
}