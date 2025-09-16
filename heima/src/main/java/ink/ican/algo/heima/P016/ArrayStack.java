package ink.ican.algo.heima.P016;

import ink.ican.algo.heima.BASE.Queue;
import ink.ican.algo.heima.BASE.Stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {

    private final E[] array;

    private int top;

    @SuppressWarnings("all")
    public ArrayStack(int capacity) {
        this.array =(E[]) new Object[capacity+1];
    }

    @Override
    public boolean push(E value) {
        if(this.isFull()){
            return false;
        }
        this.array[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if(this.isEmpty()){
            return null;
        }
        return this.array[--this.top];
    }

    @Override
    public E peek() {
        if(this.isEmpty()){
            return null;
        }
        return this.array[this.top];
    }

    @Override
    public boolean isEmpty() {
        return this.top == 0;
    }

    @Override
    public boolean isFull() {
        return this.top == this.array.length - 1;
    }

    @SuppressWarnings("all")
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top-1;
            @Override
            public boolean hasNext() {
                return p>=0;
            }
            @Override
            public E next() {
                return array[p--];
            }
        };
    }
}
