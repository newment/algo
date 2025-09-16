package ink.ican.algo.heima.P018;

import ink.ican.algo.heima.BASE.Deque;

import java.util.Iterator;

/**
 * 双向链表实现双端队列
 * @param <E>
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    Node<E> sentinel = new Node<>(null, null, null);
    int capacity;
    int size = 0;

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
    }

    @Override
    public boolean offerFirst(E e) {
        if(isFull()){
            return false;
        }
        this.sentinel.next = new Node<>(this.sentinel, e, this.sentinel.next);
        this.sentinel.next.next.prev = this.sentinel.next;
        this.size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull()){
            return false;
        }
        this.sentinel.prev.next = new Node<>(this.sentinel.prev, e, this.sentinel);
        this.sentinel.prev = this.sentinel.prev.next;
        this.size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if(this.isEmpty()){
            return null;
        }
        E value = this.sentinel.next.value;
        this.sentinel.next = this.sentinel.next.next;
        this.sentinel.next.prev = this.sentinel;
        this.size--;
        return value;
    }

    @Override
    public E pollLast() {
        if(this.isEmpty()){
            return null;
        }
        E value = this.sentinel.prev.value;
        this.sentinel.prev = this.sentinel.prev.prev;
        this.sentinel.prev.next = this.sentinel;
        size--;
        return value;
    }

    @Override
    public E peekFirst() {
        if(this.isEmpty()) return null;
        return this.sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if(this.isEmpty()) return null;
        return this.sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isFull() {
        return this.size == this.capacity;
    }

    @SuppressWarnings("all")
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = sentinel.next;
            @Override
            public boolean hasNext() {
                return this.p != sentinel;
            }

            @Override
            public E next() {
                E value = this.p.value;
                this.p = this.p.next;
                return value;
            }
        };
    }
}
