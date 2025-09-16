package ink.ican.algo.heima.P018;

public class Node<E> {
    Node<E> prev;
    E value;
    Node<E> next;

    public Node(Node<E> prev, E value, Node<E> next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
