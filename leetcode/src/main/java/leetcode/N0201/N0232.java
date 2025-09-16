package leetcode.N0201;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

/**
 * 用栈实现队列
 * 描述:请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：  void push(int x) 将元素 x 推到队列的末尾 int pop() 从队列的开头移除并返回元素 int peek() 返回队列开头的元素 boolean empty() 如果队列为空，返回 true ；否则，返回 false 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <a href="https://leetcode.cn/problems/implement-queue-using-stacks/">用栈实现队列</a>
 */
public class N0232 {



    static class MyQueue {
        private final ArrayDeque<Integer> head;
        private final ArrayDeque<Integer> tail;

        public MyQueue() {
            this.head = new ArrayDeque<>();
            this.tail = new ArrayDeque<>();
        }

        public void push(int x) {
            this.head.push(x);
        }

        public int pop() {
            if(this.tail.isEmpty()){
                while(!head.isEmpty()){
                    this.tail.push(this.head.pop());
                }
            }
            return this.tail.pop();
        }

        public int peek() {
            if(this.tail.isEmpty()){
                while(!head.isEmpty()){
                    this.tail.push(this.head.pop());
                }
            }
            assert this.tail.peek() != null;
            return this.tail.peek();
        }

        public boolean empty() {
            return this.head.isEmpty() && this.tail.isEmpty();
        }
    }


    @Test
    public void test() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty());
    }

}