package ink.ican.algo.heima.P007;

import java.util.Iterator;

public class DoublyCircularLinkedList implements Iterable<Integer> {

    private final Node sentinel = new Node(null, 0, null);

    public DoublyCircularLinkedList() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }


    public void addFirst(int value){
        Node next = this.sentinel.next;
        Node inserted = new Node(sentinel, value, next);
        this.sentinel.next = inserted;
        next.prev = inserted;
    }

    public void addLast(int value){
        Node last = this.sentinel.prev;
        Node inserted = new Node(last, value, this.sentinel);
        this.sentinel.prev = inserted;
        last.next = inserted;
    }

    public void removeFirst(){
        if(this.sentinel.next == this.sentinel){
            throw new IllegalArgumentException("非法");
        }
        Node next = this.sentinel.next.next;
        this.sentinel.next = next;
        next.prev = this.sentinel;
    }

    public void removeLast(){
        if(this.sentinel.next == this.sentinel){
            throw new IllegalArgumentException("非法");
        }
        Node prev = this.sentinel.prev.prev;
        this.sentinel.prev = prev;
        prev.next = this.sentinel;
    }

    public void removeByValue(int value){
        Node p = this.sentinel.next;
        while(p != this.sentinel){
            if(p.value == value){
                Node prev = p.prev;
                Node next = p.next;
                prev.next = next;
                next.prev = prev;
            }
            p = p.next;
        }
    }



    private Node findByValue(int value){
        Node p = this.sentinel.next;
        while(p != this.sentinel){
            if(p.value == value){
                return p;
            }
            p = p.next;
        }
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
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
