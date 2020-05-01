package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: 剑指Offer第10题 斐波那契数列
 * @Date 2020/5/1
 * @Version 1.0
 */
public class _10_斐波那契数列 {

    /**
     * 寻找通项式
     * 0 1 1 2 3 5 8 13
     *
     * n = 0 num = 0
     * n = 1 num = 1
     * n = 2 num = 1
     *
     * ......
     *
     * 当 n = k (n > 1)，f(k) = f(k - 1) + f(k - 2)
     *
     */
    public int Fibonacci(int n) {
        if (n < 2) return n;

        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        _10_斐波那契数列 solution = new _10_斐波那契数列();
        System.out.println("n= 0, result=" + solution.Fibonacci(0));
        System.out.println("n= 1, result=" + solution.Fibonacci(1));
        System.out.println("n= 5, result=" + solution.Fibonacci(5));
    }

}
