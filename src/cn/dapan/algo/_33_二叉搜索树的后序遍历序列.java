package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: 二叉搜索树：它或者是一棵空树，或者是具有下列性质的二叉树：
 *                          若它的左子树不空，则左子树所有结点的值均小于它的根结点的值；
 *                          若它的右子树不空，则右子树所有结点的值均大于它的根结点的值。
 * @Date 2020/5/7
 * @Version 1.0
 */
public class _33_二叉搜索树的后序遍历序列 {

    /*
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7  9 11
    */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;

        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        if (start >= end) return true;

        int root = sequence[end];
        int i;

        // 找到左右子树的分界点
        for (i = start; i < end; i++) {
            if (sequence[i] > root) break;
        }

        // 在右子树中判断是否含有小于root的值，如果有，不是二叉搜索树，直接返回false
        for (int j = i; j < end; j++) {
            if (sequence[j] < root) return false;
        }

        return isBST(sequence, start, i - 1) && isBST(sequence, i, end - 1);
    }

    public static void main(String[] args) {
        int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        _33_二叉搜索树的后序遍历序列 solution = new _33_二叉搜索树的后序遍历序列();
        System.out.println(solution.VerifySquenceOfBST(sequence));
        sequence = new int[]{7, 4, 6, 5};
        System.out.println(solution.VerifySquenceOfBST(sequence));
    }

}
