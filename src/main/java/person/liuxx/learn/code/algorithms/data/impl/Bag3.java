package person.liuxx.learn.code.algorithms.data.impl;

import java.util.Iterator;

import person.liuxx.learn.code.algorithms.data.Bag;

/**
 * @author 刘湘湘
 * 
 * @version 1.0.0<br>
 *          创建时间：2018年1月15日 下午2:21:23
 * 
 * @since 1.0.0
 */
public class Bag3<T> implements Bag<T> {
    private volatile Object[] array = new Object[20];
    private volatile int n = 0;

    public Bag3() {
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {
            synchronized (this) {
                @SuppressWarnings("unchecked")
                T ele = (T) array[index];
                index++;
                return ele;
            }
        }
    }

    @Override
    public synchronized void add(T ele) {
        if (n >= array.length) {
            Object[] target = new Object[n * 2];
            System.arraycopy(array, 0, target, 0, array.length);
            array = target;
        }
        array[n] = ele;
        n++;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }
}
