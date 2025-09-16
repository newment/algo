package leetcode.N0101;

import leetcode.base.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * 描述:给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/">二叉树的层序遍历</a>
 */
public class N0102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        queue.offer(root);
        int c1 = 1;
        while(!queue.isEmpty()){
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    c2++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    c2++;
                }
            }
            c1 = c2;
            result.add(temp);
            temp = new ArrayList<>();
        }
        return result;
    }




    @Test
    public void test() {
        N0102 name = new N0102();
        TreeNode parameter = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<List<Integer>> ret = name.levelOrder(parameter);
        System.out.println(ret);
    }

}