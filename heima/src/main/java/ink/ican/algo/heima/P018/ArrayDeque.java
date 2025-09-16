package ink.ican.algo.heima.P018;

import ink.ican.algo.heima.BASE.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E>, Iterable<E> {

    private final E[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public ArrayDeque(int capacity) {
        this.array = (E[]) new Object[capacity + 1];
    }

    private int inc(int i, int length) {
        if (i + 1 >= length) {
            return 0;
        }
        return i + 1;
    }

    private int dec(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;
        }
        return i - 1;
    }

    @Override
    public boolean offerFirst(E e) {
        if (this.isFull()) {
            return false;
        }
        this.head = this.dec(this.head, this.array.length);
        this.array[this.head] = e;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (this.isFull()) {
            return false;
        }
        this.array[this.tail] = e;
        this.tail = this.inc(this.tail, this.array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if(this.isEmpty()){
            return null;
        }
        E value = this.array[head];
        this.array[head] = null;
        this.head = this.inc(this.head, this.array.length);
        return value;
    }

    @Override
    public E pollLast() {
        if(this.isEmpty()){
            return null;
        }
        this.tail = this.dec(this.tail, this.array.length);
        E value =  this.array[this.tail];
        this.array[this.tail] = null;
        return value;
    }

    @Override
    public E peekFirst() {
        if(this.isEmpty()){
            return null;
        }
        return this.array[head];
    }

    @Override
    public E peekLast() {
        if (this.isEmpty()) {
            return null;
        }
        return this.array[this.tail];
    }

    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override
    public boolean isFull() {
        // return inc(this.tail, this.array.length) == this.head;
        if (this.tail > this.head) {
            return this.tail - this.head == this.array.length - 1;
        } else if (this.tail < this.head) {
            return this.head - this.tail == 1;
        } else {
            return false;
        }
    }

    @SuppressWarnings("all")
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = inc(p, array.length);
                return value;
            }
        };
    }
}
