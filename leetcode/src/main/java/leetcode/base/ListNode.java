package leetcode.base;

import leetcode.N0101.N0141;

import java.util.Random;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        ListNode p = this;
        N0141 n0141 = new N0141();
        boolean hasCycle = n0141.hasCycle(this);
        if (hasCycle) {
            ListNode f = this;
            int count = 0;
            while (p != null) {
                sb.append(p.val);
                if (p.next != null) {
                    sb.append(",");
                }
                p = p.next;
                f = f.next.next;
                if(p == f){
                    if(count++ > 1){
                        break;
                    }
                }
            }
            sb.append(p.val);
        } else {
            while (p != null) {
                sb.append(p.val);
                if (p.next != null) {
                    sb.append(",");
                }
                p = p.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static ListNode init(int n) {
        ListNode head = new ListNode(1), p = head;
        for (int i = 0; i < n; i++) {
            p.next = new ListNode(new Random().nextInt(100));
            p = p.next;
        }
        return head;
    }

    public static ListNode of(Integer... nums) {
        ListNode head = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            head = new ListNode(nums[i], head);
        }
        return head;
    }

    public ListNode tail() {
        ListNode p = this;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public ListNode getNth(int n) {
        int i = 0;
        ListNode p = this;
        while (p != null) {
            if (i++ == n) {
                return p;
            }
            p = p.next;
        }
        return null;

    }


    public static void main(String[] args) {
        ListNode init = init(10);
    }

}
