package leetcode.N0201;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * 用队列实现栈
 * 描述:请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 MyStack 类：
 * void pus(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 注意：
 * 你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * <a href="https://leetcode.cn/problems/implement-stack-using-queues/description/">用队列实现栈</a>
 */
public class N0225 {
    /**
     * 双队列模拟栈
     */
    static class MyStack {
        ArrayDeque<Integer> head;
        ArrayDeque<Integer> tail;


        public MyStack() {
            head = new ArrayDeque<>();
            tail = new ArrayDeque<>();
        }

        public void push(int x) {
            while(!this.head.isEmpty()){
                this.tail.offer(this.head.poll());
            }
            this.head.offer(x);
            while(!this.tail.isEmpty()){
                this.head.offer(this.tail.poll());
            }
        }

        public int pop() {
            return this.head.poll();
        }

        public int top() {
            return this.head.peek();
        }

        public boolean empty() {
            return this.head.isEmpty();
        }
    }

    /**
     * 单队列模拟栈
     */
    static class MyStack1 {
        ArrayDeque<Integer> queue;


        public MyStack1() {
            queue = new ArrayDeque<>(100);
        }

        public void push(int x) {
            queue.offer(x);
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return this.queue.poll();
        }

        public int top() {
            return this.queue.peek();
        }

        public boolean empty() {
            return this.queue.isEmpty();
        }
    }

    @Test
    public void test() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.top()); // 返回 2
        assertEquals(2, myStack.pop()); // 返回 2
        assertFalse(myStack.empty()); // 返回 False
    }

    @Test
    public void test1() {
        MyStack1 myStack = new MyStack1();
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.top()); // 返回 2
        assertEquals(2, myStack.pop()); // 返回 2
        assertFalse(myStack.empty()); // 返回 False
    }


}