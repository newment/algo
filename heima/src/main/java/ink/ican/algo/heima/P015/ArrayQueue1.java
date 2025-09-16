package ink.ican.algo.heima.P015;

import ink.ican.algo.heima.BASE.Queue;

import java.util.Iterator;

/**
 * 环形数组实现队列
 */
public class ArrayQueue1<E> implements Queue<E>, Iterable<E> {

    E[] array;

    int head = 0;
    int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue1(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if(this.isFull()){
            return false;
        }
        this.array[this.tail] = value;
        this.tail = (this.tail + 1)%this.array.length;
        return true;
    }

    @Override
    public E poll() {
        if(this.isEmpty()){
            return null;
        }
        E value= this.array[this.head];
        this.array[this.head] = null;
        this.head = (this.head + 1)%this.array.length;
        return value;
    }

    @Override
    public E peek() {
        if(this.isEmpty()){
            return null;
        }
        return this.array[this.head];
    }

    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override
    public boolean isFull() {
        return (this.tail + 1) %this.array.length == this.head;
    }

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
                p = (p+1) % array.length;
                return value;
            }
        };
    }
}
