package ink.ican.algo.heima.P006;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListSentinelTest {

    @Test
    public void testInsert() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);
        list.insert(0, 1);
        assertIterableEquals(List.of(1,1, 2, 3), list);

        assertThrows(IllegalArgumentException.class, () -> list.insert(5, 5));
    }

    @Test
    public void testRemove() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.insert(0, 1);
        list.insert(1, 2);
        list.insert(2, 3);
        list.insert(0, 1);

        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(0);
        assertIterableEquals(List.of(), list);

        assertThrows(IllegalArgumentException.class, () -> list.remove(0));
    }

    @Test
    public void testAddFirst() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addFirst(10);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        assertIterableEquals(List.of(3,2,1,10), list);
    }

    @Test
    public void testAddLast() {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addLast(10);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertIterableEquals(List.of(10,1,2,3), list);
    }
}
