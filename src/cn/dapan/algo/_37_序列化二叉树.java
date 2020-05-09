package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/9
 * @Version 1.0
 */
public class _37_序列化二叉树 {

    String Serialize(TreeNode root) {
        return serialize(root, new StringBuilder()).toString();
    }

    TreeNode Deserialize(String str) {

        if (str == null || str.length() == 0) return null;

        String[] split = str.split(",");
        return deserialize(split);
    }

    private int index = 0;
    private TreeNode deserialize(String[] array) {
        if (array[index].equals("#")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(array[index]));
        index++;
        root.left = deserialize(array);
        root.right = deserialize(array);
        return root;
    }

    private StringBuilder serialize(TreeNode root, StringBuilder s){
        if (root == null) {
            return s;
        }

        s.append(root.val).append(',');
        if (root.left != null) {
            serialize(root.left, s);
        } else {
            s.append("#,");
        }
        if (root.right != null) {
            serialize(root.right, s);
        } else {
            s.append("#,");
        }
        return s;
    }

    public static void main(String[] args) {
        _37_序列化二叉树 solution = new _37_序列化二叉树();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        String serialize = solution.Serialize(root);
        System.out.println(serialize);

        TreeNode treeNode = solution.Deserialize(serialize);

        solution.preOrder(treeNode);

    }

    /**
     * 前序遍历
     */
    private void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
