package ink.ican.algo.heima.P015;

import ink.ican.algo.heima.BASE.Queue;

import java.util.Iterator;

/**
 * 环形数组实现队列
 * 仅用head,tail判断空满, head,tail存储的入队数量和出队数量, 不存储索引位置, 需要转换成索引位置
 */
public class ArrayQueue4<E> implements Queue<E>, Iterable<E> {

    E[] array;

    int head = 0;
    int tail = 0;

    // 此种方法要求capacity是2的次方数
    @SuppressWarnings("all")
    public ArrayQueue4(int capacity) {
        // 方法一 校验入参, 抛异常
        // if((capacity & (capacity-1)) != 0){
        //     throw new IllegalArgumentException("入参异常");
        // }

        // 方法二 将数组长度改为大于capacity的2的次方的数
        int n = (int) (Math.log10(capacity-1) / Math.log10(2)) + 1;

        array = (E[]) new Object[1 << n];
    }


    @Override
    public boolean offer(E value) {
        if (this.isFull()) {
            return false;
        }
        // 使用Integer.toUnsignedLong是为了防止超过int范围出现负数
        int index = this.tail++ & (this.array.length - 1);
        this.array[index] = value;
        return true;
    }

    @Override
    public E poll() {
        if (this.isEmpty()) {
            return null;
        }
        int index = this.head++ & (this.array.length - 1);
        E value = this.array[index];
        this.array[index] = null;
        return value;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.array[this.head & (this.array.length - 1)];
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
                int index = this.p++ & (array.length - 1);
                ;
                return array[index];
            }
        };
    }
}
