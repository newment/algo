package leetcode.N0101;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 环形链表
 * 描述:
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <a href="https://leetcode.cn/problems/linked-list-cycle/description/">环形链表</a>
 */
public class N0141 {

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        N0141 name = new N0141();
        ListNode parameter = ListNode.of(1,2,3,4,5,6,7,8,9);
        ListNode tail = parameter.tail();
        ListNode nNode = parameter.getNth(5);
        tail.next = nNode;
        boolean ret = name.hasCycle(parameter);
        System.out.println(ret);
    }

}