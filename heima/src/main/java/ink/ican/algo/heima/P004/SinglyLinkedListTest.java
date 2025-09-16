package ink.ican.algo.heima.P004;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class SinglyLinkedListTest {


    @Test
    public void testAddFirst() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.loop1(System.out::println);
    }

    @Test
    public void testLoop() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void testAddLast() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        assertIterableEquals(List.of(5,4,3,2,1), list);
    }


    @Test
    public void testFindNode() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        assertEquals(1, list.get(5));
    }

    @Test
    public void testInsert() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        list.insert(0, 9);
        assertIterableEquals(List.of(9,5,4,3,2,1), list);
    }

    @Test
    public void testRemoveFirst() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        assertIterableEquals(List.of( ), list);
    }

    @Test
    public void testRemove() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        list.remove(4);
        assertIterableEquals(List.of(5,4,3,2), list);
    }

    /**
     * 测试递归遍历
     */
    @Test
    public void testLoop2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        list.loop2(value-> System.out.println("before:" + value), value -> System.out.println("after:" + value));
    }



}
