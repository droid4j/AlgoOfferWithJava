package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/8
 * @Version 1.0
 */
public class _8_二叉树的下一个结点 {
    /*
    以下面二叉树为例，中序遍历为：{D, B, H, E, I, A, F, C, G}
                 A
               /   \
              /     \
             B       C
            / \     / \
           D   E   F   G
              / \
             H   I

     观察，中序遍历可以归为以下几类：
     1. 有右子树，下一结点是右子树中的最左结点，例如 B，下一个结点是 H
     2. 无右子树，且结点是该结点父结点的左子树，则下一个结点是该结点的父结点，例如 H，下一个结点是 E
     3. 无右子树，且结点是该结点父结点的右子树，则我们一直沿着父结点追朔，直到找到某个结点是其父结点的左子树，如果存在这样的结点，
        那么这个结点的父结点就是我们要找的下一结点。例如 I，下一结点是 A；例如 G，并没有符合情况的结点，所以G没有下一结点
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 1
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }

        // 2
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }

        // 3
        if (pNode.next != null) {
            TreeLinkNode next = pNode.next;
            while (next.next != null && next.next.right == next) {
                next = next.next;
            }
            return next.next;
        }
        return null;
    }
}
