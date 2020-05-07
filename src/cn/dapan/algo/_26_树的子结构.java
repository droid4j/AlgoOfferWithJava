package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/7
 * @Version 1.0
 */
public class _26_树的子结构 {

    /*
                             +-----------+
                             |           |
                             |     1     |
                             |           |
                             +-----------+
                              /         \
                             /           \
                            /             \
                 +-----------+           +-----------+                 +-----------+
                 |           |           |           |                 |           |
                 |     2     |           |     3     |                 |     3     |
                 |           |           |           |                 |           |
                 +-----------+           +-----------+                 +-----------+
                  /         \             /         \                   /         \
                 /           \           /           \                 /           \
                /             \         /             \               /             \
           +-----+         +-----+   +-----+       +-----+         +-----+       +-----+
           |     |         |     |   |     |       |     |         |     |       |     |
           |  4  |         |  5  |   |  6  |       |  7  |         |  6  |       |  7  |
           |     |         |     |   |     |       |     |         |     |       |     |
           +-----+         +-----+   +-----+       +-----+         +-----+       +-----+

    注意：子结构和子树的区别
    以根节点的左节点为根的树，称为左子树，相对的，以根节点的右节点为根的树，称为右子树
    子结构，不一定是根的直接子结点，可能是孙子结点
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return judgeSubtree(root1, root2)
                || judgeSubtree(root1.left, root2)
                || judgeSubtree(root1.right, root2);
    }

    /**
     * 1. 根结点不相等，判断root1左右子树与root2是否相等
     * 2. 根结点相等，判断root1左右子树和root2的左右子树是否相等
     */
    private boolean judgeSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;

        if (root1 == null) return false;

        if (root1.val != root2.val) {
            return judgeSubtree(root1.left, root2)
                    || judgeSubtree(root1.right, root2);
        }

        return judgeSubtree(root1.left, root2.left)
                && judgeSubtree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        _26_树的子结构 solution = new _26_树的子结构();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(6);
        root2.right = new TreeNode(7);

        System.out.println(solution.HasSubtree(root1, root2));
    }
}
