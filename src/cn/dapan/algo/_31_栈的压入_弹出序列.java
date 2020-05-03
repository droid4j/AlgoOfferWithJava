package cn.dapan.algo;

import java.util.Stack;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/3
 * @Version 1.0
 */
public class _31_栈的压入_弹出序列 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int k = 0;

        for (int i = 0; i < pushA.length; i++) {
            // 压栈
            stack.push(pushA[i]);

            // 循环处理，只要栈顶与 popA 中，k 位置的元素一致，就出栈，并将 k 向后移动
            while (!stack.isEmpty() && stack.peek() == popA[k]) {
                stack.pop();
                k++;
            }
        }

        // 栈为空，表示栈的压入、弹出序列一致
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        _31_栈的压入_弹出序列 solution = new _31_栈的压入_弹出序列();
        System.out.println(solution.IsPopOrder(pushA, popA));

        popA = new int[]{4, 3, 5, 1, 2};
        System.out.println(solution.IsPopOrder(pushA, popA));
    }
}
