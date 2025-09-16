package leetcode.N0201;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 反转链表
 * <a href="https://leetcode.cn/problems/reverse-linked-list/description/">...</a>
 */
public class N0206 {

    /**
     * 自己写的, 类似reverseList1
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            head = new ListNode(p.val, head);
            p = p.next;
        }
        return head;
    }


    /**
     * 遍历旧链表将每个点加到新链表的头部
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode new1 = null, p = head;

        while (p != null) {
            new1 = new ListNode(p.val, new1);
            p = p.next;
        }
        return new1;
    }

    /**
     * 自己写的递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode result = new ListNode();
        recurive(result, head);
        return result.next;
    }

    private ListNode recurive(ListNode result, ListNode p) {
        if (p == null) {
            return null;
        }
        ListNode next = recurive(result, p.next);
        if (next != null) {
            next.next = p;
            p.next = null;
        } else {
            result.next = p;
        }
        return p;
    }

    /**
     * 更好的递归
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 从第二个节点开始将节点依次插入到第一位
     * @param o1
     * @return
     */
    public ListNode reverseList4(ListNode o1) {
        if(o1 == null || o1.next == null){
            return o1;
        }
        ListNode o2 = o1.next;
        ListNode n1 = o1;
        while(o2 != null){
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }

    /**
     * 循环将旧链表的头移到新链表的头
     * @param o1
     * @return
     */
    public ListNode reverseList5(ListNode o1) {
        ListNode n1 = null;
        while(o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }



    @Test
    public void test() {
        ListNode list = ListNode.init(5);
        System.out.println(list);
//        ListNode result = new N0206().reverseList1(list);
        ListNode result = new N0206().reverseList4(list);
        System.out.println(result);
    }
}
