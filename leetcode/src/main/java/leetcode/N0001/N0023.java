package leetcode.N0001;


import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">leetcode23</a>
 */
public class N0023 {


    public ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length ==0){
            return null;
        }
        return mergeKListsDiv(lists, 0, lists.length - 1);
    }

    public ListNode mergeKListsDiv(ListNode[] lists, int i, int j){
        if(i==j){
            return lists[i];
        }
        int m = (i+j)>>>1;
        ListNode left = mergeKListsDiv(lists, i, m);
        ListNode right = mergeKListsDiv(lists, m+1, j);
        return mergeTwoLists(left, right);
    }


    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        for (int i = 0; i < lists.length-1; i++) {
            lists[i+1] = mergeTwoLists(lists[i], lists[i+1]);
        }
        return lists[lists.length -1];
    }

    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
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

    @Test
    public void test() {
        ListNode list1 = ListNode.of(1, 4, 5);
        ListNode list2 = ListNode.of(2, 3, 4);
        ListNode list3 = ListNode.of(2, 6);
//        ListNode list1 = ListNode.of(1, 1, 4);
//        ListNode list2 = ListNode.of(1, 3, 4);
//        ListNode list3 = ListNode.of(2, 3, 3, 4);
        ListNode merge = this.mergeKLists(new ListNode[]{list1, list2, list3});
        System.out.println(merge);
    }
}
