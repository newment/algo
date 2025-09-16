package ink.ican.algo.heima.P004;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedList implements Iterable<Integer> {    // 整体

    private Node head = null;

    public void add(int index, int element){

    }

    public void addFirst(int value){
        head = new Node(value, head);
    }

    public void addLast(int value){
        Node last = this.findLast();
        if(last == null){
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    public void insert(int index, int value){
        if(index == 0){
            addFirst(value);
            return;
        }
        Node prev = this.findNode(index - 1);
        if(prev == null){
            throw new ArrayIndexOutOfBoundsException("索引超出范围");
        }
        prev.next = new Node(value, prev.next);
    }

    public Node findLast(){
        if(head == null){
            return null;
        }
        Node p = head;
        while(p.next != null){
            p = p.next;
        }
        return p;
    }

    public int get(int index){
        Node node = this.findNode(index);
        if(node == null){
            throw illegalIndex(index);
        }
        return node.value;
    }

    public void removeFirst(){
        if(head == null){
            throw illegalIndex(0);
        }
        this.head = head.next;
    }

    public void remove(int index){
        if(index == 0){
            removeFirst();
            return;
        }
        Node prev = this.findNode(index - 1);
        if(prev == null || prev.next == null){
            throw illegalIndex(index);
        }
        prev.next = prev.next.next;
    }

    private IllegalArgumentException illegalIndex(int index){
        return new IllegalArgumentException(String.format("index [%d] 不合法%n:", index));
    }

    public Node findNode(int index){
        int i = 0;
        Node p = head;
        while(p != null && i< index){
            p = p.next;
            i++;
        }
        return p;
    }


    public void loop1(Consumer<Integer> consumer){
        Node p = head;
        while(p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 递归遍历
     */
    public void loop2(Consumer<Integer> before, Consumer<Integer> after){
        this.loopRec(this.head, before, after);
    }

    private void loopRec(Node p, Consumer<Integer> before, Consumer<Integer> after){
        if(p == null){
            return;
        }
        before.accept(p.value);
        this.loopRec(p.next, before, after);
        after.accept(p.value);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator();
    }


    /**
     * 内部类, 使用到了外部类的实例成员, 则不能带static
     */
    private class NodeIterator implements Iterator<Integer> {
        Node p = head;
        @Override
        public boolean hasNext() {
            return p!= null;
        }
        @Override
        public Integer next() {
            int value = p.value;
            p = p.next;
             return value;
        }
    }
}
