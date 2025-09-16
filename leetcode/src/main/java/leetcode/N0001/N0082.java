package leetcode.N0001;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/">...</a>
 */
public class N0082 {

    /**
     * 双指针 循环往后 自己想的
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode p = sentinel;
        ListNode first, second;
        while (p.next != null && p.next.next != null) {
            first = p.next;
            second = first.next;
            if (first.val == second.val) {
                while (second != null && second.val == first.val) {
                    second = second.next;
                }
                p.next = second;
            } else {
                p = first;
            }
        }
        return sentinel.next;
    }

    /**
     * 递归方法
     * 若我与next重复, 一直找到下一个不重复的节点, 然后返回它的递归结果
     * 若我与next不重复, 返回我, 同时更新我的next节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        if(head.val == head.next.val){
            ListNode p = head.next.next;
            while(p != null && p.val == head.val){
                p = p.next;
            }
            return deleteDuplicates1(p);
        }
        else{
            head.next = deleteDuplicates1(head.next);
            return head;
        }
    }

    @Test
    public void test() {
        ListNode list = ListNode.of(1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6);
//        ListNode list = ListNode.of();
        N0082 n0082 = new N0082();
        list = n0082.deleteDuplicates1(list);
        System.out.println(list);
    }
}
