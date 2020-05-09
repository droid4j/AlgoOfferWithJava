package cn.dapan.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/9
 * @Version 1.0
 */
public class _32_3_按之字形顺序打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        leftStack.push(pRoot);
        ArrayList<Integer> level;
        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            level = new ArrayList<>();
            while (!leftStack.isEmpty()) {
                TreeNode node = leftStack.pop();
                level.add(node.val);
                if (node.left != null) rightStack.push(node.left);
                if (node.right != null) rightStack.push(node.right);
            }

            if (!level.isEmpty()) {
                result.add(level);
            }

            level = new ArrayList<>();
            while (!rightStack.isEmpty()) {
                TreeNode node = rightStack.pop();
                level.add(node.val);
                if (node.right != null) leftStack.push(node.right);
                if (node.left != null) leftStack.push(node.left);
            }

            if (!level.isEmpty()) {
                result.add(level);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _32_3_按之字形顺序打印二叉树 solution = new _32_3_按之字形顺序打印二叉树();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);


        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        ArrayList<ArrayList<Integer>> result = solution.Print(root);
        for (ArrayList<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
