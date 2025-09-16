package ink.ican.algo.heima.P015;

import ink.ican.algo.heima.BASE.Queue;

import java.util.Iterator;

/**
 * 环形数组实现队列
 * 仅用head,tail判断空满, head,tail存储的入队数量和出队数量, 不存储索引位置, 需要转换成索引位置
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {

    E[] array;

    int head = 0;
    int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (this.isFull()) {
            return false;
        }
        // 使用Integer.toUnsignedLong是为了防止超过int范围出现负数
        int index = (int) Integer.toUnsignedLong(this.tail++) % this.array.length;
        this.array[index] = value;
        return true;
    }

    @Override
    public E poll() {
        if (this.isEmpty()) {
            return null;
        }
        int index = (int) Integer.toUnsignedLong(this.head++) % this.array.length;
        E value = this.array[index];
        this.array[index] = null;
        return value;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.array[(int) Integer.toUnsignedLong(this.head) % this.array.length];
    }

    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override
    public boolean isFull() {
        return (tail - head) == this.array.length;
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
                int index = (int) Integer.toUnsignedLong(p++) % array.length;
                return array[index];
            }
        };
    }
}
