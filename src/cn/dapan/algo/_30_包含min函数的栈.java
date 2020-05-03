package cn.dapan.algo;

import java.util.Stack;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/3
 * @Version 1.0
 */
public class _30_包含min函数的栈 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);

        if (minStack.isEmpty()) { // 空时，直接将node压入
            minStack.push(node);
        } else {
            int min = minStack.peek();
            if (node < min) { // 小于栈顶时，将node 压入栈顶
                minStack.push(node);
            } else { // 大于栈顶时，将栈顶元素再次压入栈
                minStack.push(min);
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
