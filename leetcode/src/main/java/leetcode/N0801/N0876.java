package leetcode.N0801;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 链表中的中间节点
 * 描述:
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/description/">链表中的中间</a>
 */
public class N0876 {

    /**
     * 常规方法
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        int i = 0;
        for (; p != null; i++) {
            p = p.next;
        }
        if(i % 2 == 0){
            i = (i + 1) >>> 1;
        }
        else{
            i = (i - 1) >>> 1;
        }
        p = head;
        for (; i > 0; i--) {
            p = p.next;
        }
        return p;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!= null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    @Test
    public void test() {
        N0876 name = new N0876();
        ListNode parameter = ListNode.of(1, 2, 3, 4, 5, 6);
//        ListNode parameter = ListNode.of(1, 2, 3, 4, 5);
        ListNode ret = name.middleNode1(parameter);
        System.out.println(ret);
    }

}