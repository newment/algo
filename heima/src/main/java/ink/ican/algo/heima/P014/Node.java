package ink.ican.algo.heima.P014;

public class Node<E> {
    public E value;
    public Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
}