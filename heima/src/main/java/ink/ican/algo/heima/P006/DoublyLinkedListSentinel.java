package ink.ican.algo.heima.P006;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer> {

    private Node head;
    private Node tail;

    public DoublyLinkedListSentinel() {
        this.head = new Node(null, 0, null);
        this.tail = new Node(this.head, 1, null);
        this.head.next = this.tail;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n:", index));
    }

    public void addFirst(int value){
        this.insert(0, value);
    }

    public void addLast(int  value){
        Node last = this.tail.prev;
        Node inserted = new Node(last, value, this.tail);
        tail.prev = inserted;
        last.next = inserted;
    }

    public void removeLast(){
        Node last = this.tail.prev;
        if(last == null || last == this.head){
            throw illegalIndex(0);
        }
        Node prev = last.prev;
        prev.next = this.tail;
        this.tail.prev = prev;
    }
    public void insert(int index, int value) {
        Node prev = this.findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void remove(int index){
        Node prev = this.findNode(index-1);
        if(prev == null || prev.next == this.tail){
            throw illegalIndex(index);
        }
        Node next = prev.next.next;
        prev.next = next;
        next.prev = prev;
    }

    public void removeFirst() {
        this.remove(0);
    }

    public Node findNode(int index) {
        int i = -1;
        Node p = this.head;
        while (p != this.tail) {
            if (i == index) {
                return p;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
