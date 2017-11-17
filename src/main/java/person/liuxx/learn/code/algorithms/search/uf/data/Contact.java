package person.liuxx.learn.code.algorithms.search.uf.data;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年11月17日 下午1:57:50
 * @since 1.0.0
 */
public class Contact
{
    private final int id;
    private final int step;
    private final int max;
    private static Random rand = new Random();

    public Contact(int id, int step, int max)
    {
        if (id > max)
        {
            throw new AssertionError();
        }
        this.id = id;
        this.step = step;
        this.max = max;
    }

    private int left()
    {
        if (id % step == 0)
        {
            return -1;
        }
        return id - 1;
    }

    private int right()
    {
        if ((step - id % step) == 1)
        {
            return -1;
        }
        return id + 1;
    }

    private int up()
    {
        return (id - step) < 0 ? -1 : id - step;
    }

    private int down()
    {
        return (id + step) > max ? -1 : (id + step);
    }

    public Contact randomNext()
    {
        int[] array = IntStream.of(up(), down(), left(), right()).filter(i -> i >= 0).toArray();
        int index = rand.nextInt(array.length);
        return new Contact(array[index], step, max);
    }

    public int getId()
    {
        return id;
    }

    public static void main(String[] args)
    {
        Contact c = new Contact(6, 5, 9).randomNext();
        System.out.println(c.getId());
        System.out.println(c.up());
        System.out.println(c.down());
        System.out.println(c.left());
        System.out.println(c.right());
    }
}
