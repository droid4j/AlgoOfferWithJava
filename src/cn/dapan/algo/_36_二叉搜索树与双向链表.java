package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/8
 * @Version 1.0
 */
public class _36_二叉搜索树与双向链表 {

    TreeNode pre = null;
    TreeNode root = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        if (root == null) {
            root = pRootOfTree;
        }
        if (pre != null) {
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        _36_二叉搜索树与双向链表 solution = new _36_二叉搜索树与双向链表();
        TreeNode node = solution.Convert(root);
        while (node != null) {

            String left = "";
            if (node.left == null) {
                left = "NULL";
            } else {
                left = node.left.val+"";
            }

            String right = "";
            if (node.right == null) {
                right = "NULL";
            } else {
                right = node.right.val + "";
            }

            System.out.println(left + "_" + node.val + "_" + right);
            node = node.right;
        }
    }
}
