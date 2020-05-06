package cn.dapan.algo;

import java.util.Arrays;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/6
 * @Version 1.0
 */
public class _7_重建二叉树 {

    /**
     * 前序遍历序列{1,2,4,7,3,5,6,8}
     * 中序遍历序列{4,7,2,1,5,3,8,6}
     * 前序遍历第一个元素为根结点，
     * 在中序遍历中，找到与根结点对应的结点，以此分左右子树，
     * 递归求解
     * Arrays.copyOfRange(int[] original, int from, int to) , [from, to)
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length <= 0 || in.length <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) { // 以 in[i] 为界，i左侧为左子树，右侧为右子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        _7_重建二叉树 solution = new _7_重建二叉树();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode tree = solution.reConstructBinaryTree(pre, in);
        System.out.println(tree);
    }
}
