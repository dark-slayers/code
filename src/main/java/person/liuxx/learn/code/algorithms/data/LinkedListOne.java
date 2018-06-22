package person.liuxx.learn.code.algorithms.data;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2018年5月23日 下午1:42:30
 * @since 1.0.0
 */
public class LinkedListOne<E>
{
    private static class Node<E>
    {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next)
        {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    };

    private Node<E> first;
    private Node<E> last;
    private int size;

    public boolean add(E e)
    {
        linkLast(e);
        return true;
    }

    public void add(int index, E element)
    {
        checkIndexForAdd(index);
        if (index == size)
        {
            linkLast(element);
        } else
        {
            linkBefore(element, node(index));
        }
    }

    public boolean addAll(Collection<? extends E> c)
    {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection<? extends E> c)
    {
        checkIndexForAdd(index);
        Node<E> p, s;
        if (index == size)
        {
            s = null;
            p = last;
        } else
        {
            s = node(index);
            p = s.prev;
        }
        for (E e : c)
        {
            Node<E> newNode = new Node<E>(p, e, null);
            if (Objects.isNull(p))
            {
                first = newNode;
            } else
            {
                p.next = newNode;
            }
            p = newNode;
            size++;
        }
        if (Objects.isNull(s))
        {
            last = p;
        } else
        {
            p.next = s;
            s.prev = p;
        }
        return true;
    }

    public void addFirst(E e)
    {
        linkFirst(e);
    }

    public void addLast(E e)
    {
        linkLast(e);
    }

    public void clear()
    {
        // GC 该循环操作不做的情况下
        // 如果中间Node没有存在有效引用，所有元素都会在GC时被回收
        // 一旦存在中间的Node元素的任何有效引用，则会因为元素之间的相互引用导致GC不回收任何对象
        for (Node<E> x = first; Objects.nonNull(x);)
        {
            Node<E> next = x.next;
            x.item = null;
            x.prev = null;
            x.next = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    public boolean contains(Object o)
    {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o)
    {
        int index = 0;
        for (Node<E> x = first; Objects.nonNull(x); x = x.next)
        {
            if (Objects.equals(x.item, o))
            {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object o)
    {
        int index = size - 1;
        for (Node<E> x = last; Objects.nonNull(x); x = x.prev)
        {
            if (Objects.equals(x.item, o))
            {
                return index;
            }
            index--;
        }
        return -1;
    }

    public E element()
    {
        return getFirst();
    }

    public E get(int index)
    {
        return node(index).item;
    }

    public E getFirst()
    {
        if (Objects.isNull(first))
        {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    public E getLast()
    {
        if (Objects.isNull(last))
        {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    public boolean offer(E e)
    {
        return add(e);
    }

    public boolean offerFirst(E e)
    {
        addFirst(e);
        return true;
    }

    public boolean offerLast(E e)
    {
        addLast(e);
        return true;
    }

    public E peek()
    {
        return peekFirst();
    }

    public E peekFirst()
    {
        final Node<E> f = first;
        return Objects.isNull(f) ? null : f.item;
    }

    public E peekLast()
    {
        final Node<E> l = last;
        return Objects.isNull(l) ? null : l.item;
    }

    public E poll()
    {
        return pollFirst();
    }

    public E pollFirst()
    {
        final Node<E> f = first;
        if (Objects.isNull(f))
        {
            return null;
        }
        unlinkFirst();
        return f.item;
    }

    public E pollLast()
    {
        final Node<E> l = last;
        if (Objects.isNull(l))
        {
            return null;
        }
        unlinkLast();
        return l.item;
    }

    public E pop()
    {
        return removeFirst();
    }

    public void push(E e)
    {
        addFirst(e);
    }

    public E remove()
    {
        return removeFirst();
    }

    public E remove(int index)
    {
        final Node<E> n = node(index);
        return unlink(n);
    }

    public boolean remove(Object o)
    {
        for (Node<E> x = first; Objects.nonNull(x); x = x.next)
        {
            if (Objects.equals(o, x.item))
            {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    public E removeFirst()
    {
        if (Objects.isNull(first))
        {
            throw new NoSuchElementException();
        }
        return unlinkFirst();
    }

    public boolean removeFirstOccurrence(Object o)
    {
        return remove(o);
    }

    public E removeLast()
    {
        if (Objects.isNull(last))
        {
            throw new NoSuchElementException();
        }
        return unlinkLast();
    }

    public boolean removeLastOccurrence(Object o)
    {
        for (Node<E> x = first; Objects.nonNull(x); x = x.next)
        {
            if (Objects.equals(o, x.item))
            {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    public E set(int index, E element)
    {
        checkIndexForSet(index);
        final Node<E> n = node(index);
        final E oldValue = n.item;
        n.item = element;
        return oldValue;
    }

    private void checkIndexForSet(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("下标越界!index:" + index);
        }
    }

    public int size()
    {
        return size;
    }

    private E unlinkFirst()
    {
        final Node<E> f = first;
        if (Objects.isNull(f))
        {
            return null;
        }
        final Node<E> n = f.next;
        if (Objects.isNull(n))
        {
            first = null;
            last = null;
        } else
        {
            n.prev = null;
        }
        size--;
        return f.item;
    }

    private E unlinkLast()
    {
        final Node<E> l = last;
        if (Objects.isNull(l))
        {
            return null;
        }
        final Node<E> p = l.prev;
        if (Objects.isNull(p))
        {
            first = null;
            last = null;
        } else
        {
            p.next = null;
        }
        size--;
        return l.item;
    }

    private E unlink(Node<E> node)
    {
        if (Objects.isNull(node))
        {
            return null;
        }
        final Node<E> p = node.prev;
        final Node<E> n = node.next;
        final E ele = node.item;
        if (Objects.isNull(p))
        {
            first = n;
        } else
        {
            p.next = n;
        }
        if (Objects.isNull(n))
        {
            last = p;
        } else
        {
            n.prev = p;
        }
        node.item = null;
        node.prev = null;
        node.next = null;
        size--;
        return ele;
    }

    private Node<E> node(int index)
    {
        if (index < (size / 2))
        {
            Node<E> indexNode = first;
            for (int i = 0; i < index; i++)
            {
                indexNode = first.next;
            }
            return indexNode;
        } else
        {
            Node<E> indexNode = last;
            for (int i = size - 1; i > index; i--)
            {
                indexNode = last.prev;
            }
            return indexNode;
        }
    }

    private void linkBefore(E e, Node<E> node)
    {
        final Node<E> prevNode = node.prev;
        final Node<E> newNode = new Node<E>(prevNode, e, node);
        node.prev = newNode;
        if (Objects.isNull(prevNode))
        {
            first = newNode;
        } else
        {
            prevNode.next = newNode;
        }
        size++;
    }

    private void linkFirst(E e)
    {
        final Node<E> f = first;
        final Node<E> newNode = new Node<E>(null, e, f);
        first = newNode;
        if (Objects.isNull(f))
        {
            last = newNode;
        } else
        {
            f.prev = newNode;
        }
    }

    private void linkLast(E e)
    {
        final Node<E> l = last;
        final Node<E> newNode = new Node<E>(l, e, null);
        last = newNode;
        if (Objects.isNull(l))
        {
            first = newNode;
        } else
        {
            l.next = last;
        }
        size++;
    }

    private void checkIndexForAdd(int index)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("下标越界！");
        }
    }
}
