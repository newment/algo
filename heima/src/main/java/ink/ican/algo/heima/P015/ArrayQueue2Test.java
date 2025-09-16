package ink.ican.algo.heima.P015;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueue2Test {
    @Test
    public void test() {
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(5);
        // assertTrue(queue.isEmpty());
        // assertFalse(queue.isFull());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        assertFalse(queue.offer(6));

        assertFalse(queue.isEmpty());
        assertTrue(queue.isFull());


        assertEquals(1, queue.peek());

        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertEquals(3, queue.poll());
        assertEquals(4, queue.poll());
        assertEquals(5, queue.poll());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());


        queue.offer(6);
        queue.offer(7);
        assertEquals(6, queue.poll());
        assertEquals(7, queue.poll());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());

        queue.offer(8);
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());

    }

}
