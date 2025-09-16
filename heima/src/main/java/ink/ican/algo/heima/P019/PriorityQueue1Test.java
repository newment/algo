package ink.ican.algo.heima.P019;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueue1Test {
    @Test
    public void test() {
        PriorityQueue1<Entry> queue = new PriorityQueue1<>(4);
        queue.offer(new Entry("1", 1));
        queue.offer(new Entry("4", 4));
        queue.offer(new Entry("2", 2));
        queue.offer(new Entry("3", 3));
        assertFalse(queue.offer(new Entry("6", 6)));

        assertEquals(4, queue.poll().priority());
        assertEquals(3, queue.poll().priority());
        assertEquals(2, queue.poll().priority());
        assertEquals(1, queue.poll().priority());



    }

}
