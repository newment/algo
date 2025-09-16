package ink.ican.algo.heima.P016;

import ink.ican.algo.heima.BASE.Stack;
import ink.ican.algo.heima.P014.Node;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable<E> {

    private final int capacity;

    private int size = 0;

    private Node<E> head = new Node<>(null, null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        if(this.isFull()){
            return false;
        }
        this.head.next = new Node<E>(value, this.head.next);
        this.size++;
        return true;
    }

    @Override
    public E pop() {
        if(this.isEmpty()){
            return null;
        }
        E value = this.head.next.value;
        this.head.next = this.head.next.next;
        this.size--;
        return value;
    }

    @Override
    public E peek() {
        if(this.isEmpty()){
            return null;
        }
        return this.head.next.value;
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
            Node<E> p = head.next;
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                count++;
                return value;
            }
        };
    }
}
