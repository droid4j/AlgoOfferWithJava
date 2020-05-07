package cn.dapan.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/7
 * @Version 1.0
 */
public class _27_二叉树的镜像 {

    /*
    二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
     */

    /**
     * 遍历法，借助队列
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 先交换
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // 再放入队列
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

    }

    /**
     * 递归实现
     * @param root
     */
    public void Mirror1(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror1(root.left);
        Mirror1(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        print(root);

        _27_二叉树的镜像 solution = new _27_二叉树的镜像();
        solution.Mirror(root);

        print(root);
    }

    private static void print(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println();
    }
}
