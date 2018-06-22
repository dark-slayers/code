package person.liuxx.learn.code.algorithms.data;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年4月4日 下午3:04:24
 * @since 1.0.0
 */
public class ArrayListOne<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable,
        Serializable
{
    private static final long serialVersionUID = -6897165363871411502L;
    private static final int DEFALUT_SIZE = 10;
//    private static final Object[] EMPTY_ARRAY = {};
    private Object[] eleArray;
    private int size;

    public ArrayListOne()
    {
        eleArray = new Object[DEFALUT_SIZE];
    }

    public ArrayListOne(int size)
    {
        eleArray = new Object[size];
    }

    public ArrayListOne(Collection<? extends E> c)
    {
        eleArray = c.toArray();
        if (Objects.equals(eleArray.getClass(), Object[].class))
        {
            eleArray = Arrays.copyOf(eleArray, eleArray.length, Object[].class);
        }
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
        for (int i = 0; i < size; i++)
        {
            eleArray[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean add(E e)
    {
        ensureCapacity(size + 1);
        eleArray[size] = e;
        size++;
        return true;
    }

    /**
     * 如有必要，增加此 ArrayList 实例的容量，以确保它至少能够容纳最小容量参数所指定的元素数。
     * 
     * @param minCapacity
     *            所需的最小容量
     * 
     */
    public void ensureCapacity(int minCapacity)
    {
        minCapacity = Math.max(minCapacity, DEFALUT_SIZE);
        if (minCapacity > size)
        {
            grow(minCapacity);
        }
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
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(eleArray, index, eleArray, index + 1, size - index);
        eleArray[index] = element;
        size++;
    }

    private void rangeCheckForAdd(int index)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("下标越界：" + index);
        }
    }

    @Override
    public boolean contains(Object o)
    {
        return indexOf(o) >= 0;
    }

    @Override
    public int indexOf(Object o)
    {
        for (int i = 0; i < size; i++)
        {
            if (Objects.equals(eleArray[i], o))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public String toString()
    {
        return super.toString() + ",array length:" + eleArray.length;
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        Object[] addArray = c.toArray();
        int addNum = addArray.length;
        ensureCapacity(size + addNum);
        System.arraycopy(addArray, 0, eleArray, size, addNum);
        size = size + addNum;
        return addNum != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        Object[] addArray = c.toArray();
        int addNum = addArray.length;
        ensureCapacity(size + addNum);
        System.arraycopy(eleArray, index, eleArray, index + addNum, size - index);
        System.arraycopy(addArray, 0, eleArray, index, addNum);
        size = size + addNum;
        return addNum != 0;
    }

    @Override
    public Object clone()
    {
        ArrayListOne<?> v;
        try
        {
            v = (ArrayListOne<?>) super.clone();
            v.eleArray = Arrays.copyOf(eleArray, size);
            return v;
        } catch (CloneNotSupportedException e)
        {
            throw new InternalError(e);
        }
    }

    @Override
    public int lastIndexOf(Object o)
    {
        int lastIndex = -1;
        for (int i = 0; i < size; i++)
        {
            if (Objects.equals(eleArray[i], o))
            {
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override
    public E remove(int index)
    {
        rangeCheckForRemove(index);
        E ele = elementData(index);
        System.arraycopy(eleArray, index + 1, eleArray, index, size - index - 1);
        eleArray[size - 1] = null;
        size--;
        return ele;
    }

    private void rangeCheckForRemove(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("下标越界：" + index);
        }
    }

    @Override
    public boolean remove(Object o)
    {
        for (int i = 0; i < size; i++)
        {
            if (Objects.equals(o, eleArray[i]))
            {
                System.arraycopy(eleArray, i + 1, eleArray, i, size - i - 1);
                eleArray[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    protected void removeRange(int fromIndex, int toIndex)
    {
    }

    @Override
    public E set(int index, E element)
    {
        rangeCheckForRemove(index);
        E oldValue = elementData(index);
        eleArray[index] = element;
        return oldValue;
    }

    @Override
    public Object[] toArray()
    {
        return Arrays.copyOf(eleArray, size);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a)
    {
        if (a.length <= size)
        {
            return (T[]) Arrays.copyOf(eleArray, size, a.getClass());
        } else
        {
            System.arraycopy(eleArray, 0, a, 0, size);
            return a;
        }
    }

    public Iterator<E> iterator()
    {
        return new Itr();
    }

    private class Itr implements Iterator<E>
    {
        int cursor = 0;
        int count = size;

        Itr()
        {
        }

        @Override
        public boolean hasNext()
        {
            return cursor < count;
        }

        @Override
        public E next()
        {
            E ele = elementData(cursor);
            cursor++;
            return ele;
        }

        public void remove()
        {
            ArrayListOne.this.remove(cursor);
            count--;
        }
    }

    public ListIterator<E> listIterator()
    {
        return new ListItr(0);
    }

    private class ListItr extends Itr implements ListIterator<E>
    {
        ListItr(int index)
        {
            super();
            cursor = index;
        }

        @Override
        public boolean hasPrevious()
        {
            return cursor > 0;
        }

        @Override
        public E previous()
        {
            return elementData(--cursor);
        }

        @Override
        public int nextIndex()
        {
            return cursor;
        }

        @Override
        public int previousIndex()
        {
            return cursor - 1;
        }

        @Override
        public void set(E e)
        {
            ArrayListOne.this.set(cursor, e);
        }

        @Override
        public void add(E e)
        {
            ArrayListOne.this.add(cursor, e);
            count++;
        }
    }

    public ListIterator<E> listIterator(int index)
    {
        return new ListItr(index);
    }

    // public List<E> subList(int fromIndex, int toIndex)
    // {
    //
    // }
    public boolean removeAll(Collection<?> c)
    {
        Objects.requireNonNull(c);
        return batchRemove(c, false);
    }

    public boolean retainAll(Collection<?> c)
    {
        Objects.requireNonNull(c);
        return batchRemove(c, true);
    }

    private boolean batchRemove(Collection<?> c, boolean complement)
    {
        int w = 0, r = 0;
        boolean modify = false;
        try
        {
            for (; w < size; w++)
            {
                if (c.contains(eleArray[w]) == complement)
                {
                    eleArray[r] = eleArray[w];
                    r++;
                }
            }
        } finally
        {
            // 如果c.contains(eleArray[w])产生异常，需要把w之后的数据移动至r并更新r
            if (w < size)
            {
                System.arraycopy(eleArray, w, eleArray, r, size - w);
                r = r + (size - w);
            }
            if (r < size)
            {
                // 不使用的元素设置为null,GC时可以被回收
                for (int i = r; i < size; i++)
                {
                    eleArray[i] = null;
                }
                size = r;
                modify = true;
            }
        }
        return modify;
    }

    @Override
    public void forEach(Consumer<? super E> action)
    {
        for (int i = 0; i < size; i++)
        {
            action.accept(elementData(i));
        }
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter)
    {
        for (int i = 0; i < size; i++)
        {
            if (filter.test(elementData(i)))
            {
                System.arraycopy(eleArray, i + 1, eleArray, i, size - i);
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void sort(Comparator<? super E> c)
    {
        Arrays.sort((E[]) eleArray, 0, size, c);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator)
    {
    }
    //
    // @Override
    // public Spliterator<E> spliterator()
    // {
    // }

    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException
    {
        s.defaultWriteObject();
        // Write out size as capacity for behavioural compatibility with clone()
        s.writeInt(size);
        // Write out all elements in the proper order.
        for (int i = 0; i < size; i++)
        {
            s.writeObject(eleArray[i]);
        }
    }
}
