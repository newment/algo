package ink.ican.algo.heima.P016;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListStackTest {
    @Test
    public void test() {
        LinkedListStack<Integer> stack = new LinkedListStack<>(4);
        assertTrue(stack.isEmpty());
        assertFalse(stack.isFull());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertFalse(stack.isEmpty());
        assertFalse(stack.isFull());
        stack.push(4);

        for (Integer i : stack) {
            System.out.println(i);
        }

        assertFalse(stack.isEmpty());
        assertTrue(stack.isFull());

        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

        assertTrue(stack.isEmpty());
        assertFalse(stack.isFull());

    }


}
