package ink.ican.algo.heima.P014;

import ink.ican.algo.heima.BASE.Queue;

import java.util.Iterator;

/**
 * 链表实现队列
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {

    Node<E> head = new Node<>(null, null);
    Node<E> tail = head;
    int size;
    int capacity = Integer.MAX_VALUE;

    {
        this.tail.next = this.head;
    }

    public LinkedListQueue() {
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public boolean offer(E value) {
        if(this.isFull()){
            return false;
        }
        Node<E> added = new Node<>(value, this.head);
        this.tail.next = added;
        this.tail = added;
        this.size++;
        return true;
    }

    /**
     * 需要考虑被删除队列只有一个节点时需单独处理
     */
    @Override
    public E poll() {
        if(this.isEmpty()) return null;
        E value = this.head.next.value;
        this.head.next = this.head.next.next;
        size--;
        if(this.head.next == this.head){
            this.tail = this.head;
        }
        return value;

    }

    @Override
    public E peek() {
        if(this.head == this.tail) return null;
        return this.head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
        // return this.head == this.tail;
    }

    @Override
    public boolean isFull() {
        return this.capacity == this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p =head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }


}
