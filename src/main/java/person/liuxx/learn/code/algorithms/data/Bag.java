package person.liuxx.learn.code.algorithms.data;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年1月15日 上午10:03:58
 * @since 1.0.0
 */
public interface Bag<T> extends Iterable<T>
{
    void add(T ele);

    boolean isEmpty();

    int size();
}
