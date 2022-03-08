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
public class Bag2<T> implements Bag<T> {
    private Object[] array = new Object[0];

    public Bag2() {
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {
            @SuppressWarnings("unchecked")
            T ele = (T) array[index];
            index++;
            return ele;
        }
    }

    @Override
    public synchronized void add(T ele) {
        Object[] target = new Object[size() + 1];
        System.arraycopy(array, 0, target, 0, array.length);
        target[array.length] = ele;
        array = target;
    }

    @Override
    public synchronized boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public synchronized int size() {
        return array.length;
    }
}
