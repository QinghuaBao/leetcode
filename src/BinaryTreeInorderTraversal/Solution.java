package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by bqh on 2018/3/18.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while(root != null || !treeNodeStack.empty())
        {
            while (root != null)
            {
                treeNodeStack.push(root);
                root = root.left;
            }
            if(!treeNodeStack.empty())
            {
                root = treeNodeStack.pop();
                inorderList.add(root.val);
                root = root.right;
            }
        }
        return inorderList;
    }
}
