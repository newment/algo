package leetcode.N0101;

import leetcode.base.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 * 描述:给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">二叉树的锯齿形层序遍历</a>
 */
public class N0103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> temp = new ArrayList<>();
        deque.offer(root);
        int c1 = 1;
        boolean odd = true;
        while(!deque.isEmpty()){
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = deque.poll();
                if(odd){
                    temp.addLast(node.val);
                }
                else{
                    temp.addFirst(node.val);
                }
                if(node.left != null){
                    deque.offer(node.left);
                    c2++;
                }
                if(node.right != null){
                    deque.offer(node.right);
                    c2++;
                }
            }
            odd = !odd;
            c1 = c2;
            result.add(temp);
            temp = new ArrayList<>();
        }
        return result;
    }

    @Test
    public void test() {
        N0103 name = new N0103();
        TreeNode parameter = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<List<Integer>> ret = name.zigzagLevelOrder(parameter);
        System.out.println(ret);
    }

}