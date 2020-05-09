package cn.dapan.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/9
 * @Version 1.0
 */
public class _54_二叉搜索树的第k个结点 {

    ArrayList<TreeNode> kthNode = new ArrayList<>();
    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);

        if (k >= 1 && kthNode.size() >= k) {
            return kthNode.get(k - 1);
        }
        return null;
    }

    // 中序遍历，第k个元素即可
    private void inOrder(TreeNode root, int k) {
        if (root != null) {
            inOrder(root.left, k);
            k--;
            kthNode.add(root);
            if (k <= 0) {
                return;
            }
            inOrder(root.right, k);

        }
    }

    /*
            5
          /   \
         3     7
        / \   / \
       2   4 6   8
     */
    public static void main(String[] args) {
        _54_二叉搜索树的第k个结点 solution = new _54_二叉搜索树的第k个结点();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println(solution.KthNode(root, 3).val);
    }
}
