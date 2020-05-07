package cn.dapan.algo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/8
 * @Version 1.0
 */
public class _34_二叉树中和为某一值的路径 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<>();
        find(root, target, result, path);
        return result;
    }

    private void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (target < 0) {
            return;
        }

        if (target == 0 && root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        find(root.left, target, result, new ArrayList<>(path));
        find(root.right, target, result, new ArrayList<>(path));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        _34_二叉树中和为某一值的路径 solution = new _34_二叉树中和为某一值的路径();
        ArrayList<ArrayList<Integer>> paths = solution.FindPath(root, 22);
        for (ArrayList<Integer> path : paths) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
