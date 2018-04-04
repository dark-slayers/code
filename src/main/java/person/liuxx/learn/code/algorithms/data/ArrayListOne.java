package person.liuxx.learn.code.algorithms.data;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月4日 下午3:04:24
 * @since 1.0.0
 */
public class ArrayListOne<E> extends AbstractList<E> implements List<E>, RandomAccess,
        Cloneable, Serializable
{
    private static final long serialVersionUID = -6897165363871411502L;
    private static final int DEFALUT_SIZE = 10;
    private static final Object[] EMPTY_ARRAY = {};
    private Object[] eleArray;
    private int size;

    public ArrayListOne()
    {
        eleArray = new Object[DEFALUT_SIZE];
    }

    public ArrayListOne(int size)
    {
    }

    public ArrayListOne(Collection<? extends E> c)
    {
    }

    @Override
    public E get(int index)
    {
        if (index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException("下标越界！index:" + index + ",size:" + size);
        }
        return elementData(index);
    }

    @SuppressWarnings("unchecked")
    private E elementData(int index)
    {
        return (E) eleArray[index];
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void clear()
    {
        eleArray = EMPTY_ARRAY;
        size = 0;
    }

    @Override
    public boolean add(E e)
    {
        grow(size + 1);
        eleArray[size] = e;
        size++;
        return true;
    }

    private void grow(int minCapacity)
    {
        if (minCapacity < 0)
        {
            throw new OutOfMemoryError();
        }
        int oldCapacity = eleArray.length;
        if (minCapacity < oldCapacity)
        {
            return;
        }
        if (minCapacity < DEFALUT_SIZE)
        {
            minCapacity = DEFALUT_SIZE;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < 0)
        {
            throw new OutOfMemoryError();
        }
        if (newCapacity < minCapacity)
        {
            newCapacity = minCapacity;
        }
        eleArray = Arrays.copyOf(eleArray, newCapacity);
    }

    @Override
    public void add(int index, E element)
    {
    }

    @Override
    public String toString()
    {
        return super.toString() + ",array length:" + eleArray.length;
    }
}
