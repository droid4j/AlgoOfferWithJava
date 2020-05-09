package cn.dapan.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/9
 * @Version 1.0
 */
public class _32_2_把二叉树打印成多行 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(pRoot);
        ArrayList<Integer> level = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            level = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode node = queue1.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue2.offer(node.left);
                }

                if (node.right != null) {
                    queue2.offer(node.right);
                }
            }

            if (!level.isEmpty()) {
                result.add(level);
            }

            level = new ArrayList<>();
            while (!queue2.isEmpty()) {
                TreeNode node = queue2.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue1.offer(node.left);
                }

                if (node.right != null) {
                    queue1.offer(node.right);
                }
            }

            if (!level.isEmpty()) {
                result.add(level);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _32_2_把二叉树打印成多行 solution = new _32_2_把二叉树打印成多行();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        ArrayList<ArrayList<Integer>> result = solution.Print(root);
        for (ArrayList<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
