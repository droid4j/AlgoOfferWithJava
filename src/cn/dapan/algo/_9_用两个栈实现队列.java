package cn.dapan.algo;

import java.util.Stack;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/2
 * @Version 1.0
 */
public class _9_用两个栈实现队列 {

    private Stack<Integer> topStack = new Stack<>();
    private Stack<Integer> tailStack = new Stack<>();

    public void push(int node) {
        topStack.push(node);
    }

    public int pop() {

        // stack2 为空时，将 stack1 压入 stack2，否则直接从 stack2 中弹出即可
        if (tailStack.isEmpty()) {
            while (!topStack.isEmpty()) {
                tailStack.push(topStack.pop());
            }
        }

        return tailStack.pop();
    }

    public static void main(String[] args) {
        _9_用两个栈实现队列 solution = new _9_用两个栈实现队列();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.pop());
        solution.push(3);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}
