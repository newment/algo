package ink.ican.algo.heima.P005;

import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyLinkedListSentinel implements Iterable<Integer> {    // 整体

    private Node head = new Node(0, null);

    public void add(int index, int element) {

    }

    public void addFirst(int value) {
        this.insert(0, value);
    }

    public void addLast(int value) {
        Node last = this.findLast();
        last.next = new Node(value, null);
    }

    public void insert(int index, int value) {
        Node prev = this.findNode(index - 1);
        if (prev == null) {
            throw new ArrayIndexOutOfBoundsException("索引超出范围");
        }
        prev.next = new Node(value, prev.next);
    }

    public Node findLast() {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public int get(int index) {
        Node node = this.findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    public void removeFirst() {
        remove(0);
    }

    public void remove(int index) {
        Node prev = this.findNode(index - 1);
        if (prev == null || prev.next == null) {
            throw illegalIndex(index);
        }
        prev.next = prev.next.next;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n:", index));
    }

    public Node findNode(int index) {
        int i = -1;
        Node p = head;
        while (p != null && i < index) {
            p = p.next;
            i++;
        }
        return p;
    }


    public void loop1(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new NodeIterator();
    }


    /**
     * 内部类, 使用到了外部类的实例成员, 则不能带static
     */
    private class NodeIterator implements Iterator<Integer> {
        Node p = head.next;

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public Integer next() {
            int value = p.value;
            p = p.next;
            return value;
        }
    }
}
