package leetcode.N0201;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 回文链表
 * 描述: 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/">回文链表</a>
 */
public class N0234 {



    /**
     * 优化循环
     * 思路, 在找中间节点的过程中将前半部分链表反转, 减少循环
     * @param head
     * @return
     */
    public boolean isPalindromeAlt(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        ListNode reversed = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            head.next = reversed;
            reversed = head;
            head = slow;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(reversed != null){    // 反转后的链表长度一定更短
            if(slow.val != reversed.val){
                return false;
            }
            slow = slow.next;
            reversed = reversed.next;
        }
        return true;
    }

    /**
     * 效率更高方法
     * 先找到中间节点,再将后半部分反转, 然后和前半部分比较, 一样的话则是回文链表, 注意反转要反转原链表
     * 1. 找中间节点
     * 2. 反转后半部分链表
     * 3. 比较原链表和反转后链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversed = reverseList(slow);
        while(reversed != null){    // 反转后的链表长度一定更短
            if(head.val != reversed.val){
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }


    /**
     * 不创建节点, 直接反转原链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode n1 = null;
        while(head != null){
            ListNode o2 = head.next;
            head.next = n1;
            n1 = head;
            head = o2;
        }
        return n1;
    }

    /**
     * 新建一个反转链表, 将原链表和新链表从头比较, 一样的话则是, 否则不是
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {

        ListNode reversed = reverseList1(head);
        ListNode p1 = head;
        ListNode p2 = reversed;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 != null || p2 != null) {
            return false;
        }
        return true;
    }
    /**
     * 新创建节点
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;
        ListNode pn = newHead;
        while (p != null) {
            pn = new ListNode(p.val, pn);
            p = p.next;
        }
        return pn;
    }

    @Test
    public void test() {
        N0234 name = new N0234();
        ListNode parameter = ListNode.of(1, 2, 3, 4, 3, 2, 1);
        boolean ret = name.isPalindromeAlt(parameter);
        System.out.println(ret);
    }

}