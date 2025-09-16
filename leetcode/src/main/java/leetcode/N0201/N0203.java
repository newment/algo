package leetcode.N0201;

import leetcode.base.ListNode;
import org.junit.jupiter.api.Test;

/**
 * 移除链表元素
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/">...</a>
 */
public class N0203 {
    /**
     * 自己想的
     * 循环源链表, 依次将原链表的不等于val值的元素添加到新链表中
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head;
        ListNode nHead = new ListNode(0), nLast = nHead;
        while (p != null) {
            if(p.val != val){
                nLast.next= new ListNode(p.val, null);
                nLast = nLast.next;
            }
            p = p.next;
        }
        return nHead.next;
    }

    /**
     * 循环判断后一个元素是否等于val, 等于的直接将当前节点的next指向下下个节点, 不等于的继续往后走
     * 开始想到这个方法, 但是因为头结点可能为空, 实现复杂, 就放弃了, leetcode看到的解法, 加个哨兵节点就好处理了, 没想到
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode p = sentinel;
        while(p.next != null){
            if(p.next.val == val){
                p.next = p.next.next;
            }
            else{
                p = p.next;     // 注意, 这里要写到else里面, 相同时, 不能往后移动
            }
        }
        return sentinel.next;
    }

    /**
     * 递归
     * 递归函数负责返回, 从当前节点开始, 完成删除
     * 1. 若当前节点val与val相等, 应该返回下一个节点的递归结果
     * 2. 若当前节点val与val不相等, 应该返回我, 但是我的next节点应该更新为递归的结果
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null){
            return head;
        }
        if(head.val == val){
            return removeElements2(head.next, val);
        }
        else{
            head.next = removeElements2(head.next, val);
            return head;
        }
    }

    @Test
    public void test() {
        ListNode list = ListNode.of(7,7,7,7);
        System.out.println(list);
//        ListNode result = new N0206().reverseList1(list);
        ListNode result = new N0203().removeElements2(list, 7);
        System.out.println(result);
    }
}
