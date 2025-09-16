package leetcode.N0001;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">leetcode21</a>
 */
public class N0021 {
    /**
     * 循环将两个list的节点放到新list中
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        ListNode sentinel = new ListNode();
        ListNode p = sentinel;
        while (p1 != null || p2 != null) {
            if(p2 == null || (p1 != null && p1.val <= p2.val)){
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            }
            else{
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        return sentinel.next;
    }

    /**
     * 上述方法优化
     * @param p1
     * @param p2
     * @return
     */
    public ListNode mergeTwoListsAlt(ListNode p1, ListNode p2) {
        ListNode sentinel = new ListNode();
        ListNode p = sentinel;
        while (p1 != null && p2 != null) {
            if(p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            }
            else{
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        if(p1 == null){
            p.next = p2;
        }
        if(p2 == null){
            p.next = p1;
        }
        return sentinel.next;
    }

    /**
     * 递归方法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        ListNode p = null;
        if(list1 == null){
            p = list2;
        }
        else if(list2 == null){
            p = list1;
        }
        else if(list1.val <= list2.val){
            p = list1;
            p.next = mergeTwoLists1(list1.next, list2);
        }
        else{
            p = list2;
            p.next = mergeTwoLists1(list1, list2.next);
        }
        return p;
    }

    /**
     * 递归优化版
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        }
        list2.next = mergeTwoLists1(list1, list2.next);
        return list2;
    }

    @Test
    public void test() {
        ListNode list1 = ListNode.of(1, 2, 3, 4, 5);
        ListNode list2 = ListNode.of(2, 3, 3, 4);
//        ListNode list1 = ListNode.of(1, 1, 4);
//        ListNode list2 = ListNode.of(1, 3, 4);
//        ListNode merge = this.mergeTwoLists(list1, list2);
        ListNode merge = this.mergeTwoListsAlt(list1, list2);
        System.out.println(merge);
    }
}
