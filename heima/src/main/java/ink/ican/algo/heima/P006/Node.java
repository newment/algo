package ink.ican.algo.heima.P006;

public class Node {
    Node prev;
    int value;
    Node next;

    public Node(Node prev, int value, Node next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
