package ink.ican.algo.heima.P018;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListDequeTest {

    @Test
    public void test() {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(4);
        assertTrue(deque.isEmpty());
        assertFalse(deque.isFull());
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerFirst(4);

        for (Integer i : deque) {
            System.out.println(i);
        }

        assertFalse(deque.isEmpty());
        assertTrue(deque.isFull());
        assertEquals(4, deque.pollFirst());
        assertEquals(3, deque.pollFirst());
        assertEquals(2, deque.pollFirst());
        assertEquals(1, deque.pollFirst());

        assertTrue(deque.isEmpty());
        assertFalse(deque.isFull());

        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);

        assertFalse(deque.isEmpty());
        assertTrue(deque.isFull());

        assertEquals(4, deque.pollLast());
        assertEquals(3, deque.pollLast());
        assertEquals(2, deque.pollLast());
        assertEquals(1, deque.pollLast());

        assertTrue(deque.isEmpty());
        assertFalse(deque.isFull());
    }

}
