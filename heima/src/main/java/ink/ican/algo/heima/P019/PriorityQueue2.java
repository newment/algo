package ink.ican.algo.heima.P019;

import ink.ican.algo.heima.BASE.Priority;
import ink.ican.algo.heima.BASE.Queue;

import java.util.Iterator;

/**
 * 基于有序数组实现
 *
 * @param <E>
 */
public class PriorityQueue2<E extends Priority> implements Queue<E>, Iterable<E> {

    private E[] array;
    int size;

    @SuppressWarnings("all")
    public PriorityQueue2(int capacity) {
        this.array = (E[]) new Priority[capacity];
    }


    private void insert(E value) {
        int i = this.size -1;
        while(i>=0 && this.array[i].priority() > value.priority()){
            this.array[i+1] = this.array[i];
            i--;
        }
        this.array[i + 1] = value;
    }

    @Override
    public boolean offer(E value) {
        if (this.isFull()) {
            return false;
        }
        this.insert(value);
        this.size++;
        return true;
    }

    private int selectMax() {
        int max = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].priority() > this.array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    private void remove(int index) {
        if (index < this.size - 1) {
            System.arraycopy(this.array, index + 1, this.array, index, size - index - 1);
        }
        this.size--;
    }

    @Override
    public E poll() {
        if (this.isEmpty()) {
            return null;
        }
        E value = this.array[size - 1];
        this.array[size-- - 1] = null;
        return value;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        int i = this.selectMax();
        return this.array[i];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isFull() {
        return this.array.length == this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
