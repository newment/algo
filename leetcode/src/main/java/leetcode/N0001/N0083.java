package leetcode.N0001;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

/**
 *
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/">...</a>
 */
public class N0083 {

    /**
     * 循环方法
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p != null && p.next != null){
            if(p.next.val == p.val){
                p.next = p.next.next;
            }
            else{
                p = p.next;
            }
        }
        return head;
    }

    /**
     * 递归方法1
     * 自己想的, 先从后递归, 每次和后面的比较, 如果相同把后面的移除
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = deleteDuplicates(head.next);
        if(head.val == next.val){
            head.next = next.next;
        }
        return head;
    }

    /**
     * 递归方法2
     * 先比较当前和后面的,再递归处理
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.val == head.next.val){
            return deleteDuplicates(head.next);
        }
        else{
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }



    @Test
    public void test() {
        ListNode list = ListNode.of(1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5);
//        ListNode list = ListNode.of();
        N0083 n0083 = new N0083();
        list = n0083.deleteDuplicates2(list);
        System.out.println(list);
    }
}
