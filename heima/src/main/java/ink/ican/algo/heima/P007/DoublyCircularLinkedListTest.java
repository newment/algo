package ink.ican.algo.heima.P007;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyCircularLinkedListTest {

    private DoublyCircularLinkedList getList(){
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        return list;
    }


    @Test
    public void testAddFirst() {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        assertIterableEquals(List.of(4,3,2,1), list);
    }

    @Test
    public void testAddLast() {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        assertIterableEquals(List.of(1,2,3,4), list);
    }

    @Test
    public void testRemvoeFirst() {
        DoublyCircularLinkedList list = this.getList();
        list.removeFirst();
        assertIterableEquals(List.of(2,3,4), list);
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeFirst);
    }

    @Test
    public void testRemvoeLast() {
        DoublyCircularLinkedList list = this.getList();
        list.removeLast();
        assertIterableEquals(List.of(1,2,3), list);
        list.removeLast();
        list.removeLast();
        list.removeLast();
        assertIterableEquals(List.of(), list);
        assertThrows(IllegalArgumentException.class, list::removeLast);
    }

    @Test
    public void testRemvoeByValue() {
        DoublyCircularLinkedList list = this.getList();
        list.addLast(1);
        list.removeByValue(1);
        assertIterableEquals(List.of(2,3,4), list);
    }




}
