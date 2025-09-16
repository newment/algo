package leetcode.N0001;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;


/**
 * <a name="" href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/"/>leet code</a>
 */
public class N0019 {

    /**
     * 递归, 自己想的
     * 也可以在外部加个哨兵节点, 这样外面就不用单独处理了
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = this.countAndRemove(head, n);
        if (count == n) {
            return head.next;
        }
        return head;
    }

    public int countAndRemove(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int count = countAndRemove(head.next, n);
        if (count == n) {
            head.next = head.next.next;
        }
        return count + 1;
    }

    /**
     * 循环解法, 只能两次遍历
     * 自己的方法: 思路,找到总数, 再从头找到差值减掉
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode sentinel = new ListNode(0, head);
        ListNode p = sentinel;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        p = sentinel;
        for (int i = 0; i < count - n -1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return sentinel.next;
    }

    /**
     * 双指针方法: 先将第一个指针向后移动n+1位,再增加一个指针从头开始, 两个同时移动到最后, 最后删除第二个位置的指针即可
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode sentinel = new ListNode(0, head);
        ListNode first = sentinel;
        ListNode second = sentinel;

        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return sentinel.next;
    }



    @Test
    public void test() {
//        ListNode listNode = ListNode.of(1, 2, 3, 4, 5);
        ListNode listNode = ListNode.of(1);
        listNode = this.removeNthFromEnd2(listNode, 1);
        System.out.println(listNode);
    }
}
