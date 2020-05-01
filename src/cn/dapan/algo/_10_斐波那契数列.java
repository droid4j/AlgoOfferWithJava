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

    /**
     * 递归虽然简洁，但是有两个非常明显的缺点：
     *  1. 重复计算，比如：n = 5时，f(5) = f(4) + f(3), f(4) = f(3) + f(2)，从这两个式子中，可以看出 f(3)被计算了两次
     *  2. 当调用栈比较深时，程序会变得非常的慢，甚至报错
     *
     *  非递归方式
     *  1. 只需要一层for循环即可，避免了方法的重复调用
     *  2. 每一轮的结果保存到了 ret，结果不需要重复计算了
     *
     */
    public int Fibonacci2(int n) {
        if (n < 2) return n;

        int f1 = 0;
        int f2 = 1;
        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = f2 + f1;
            f1 = f2;
            f2 = ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        _10_斐波那契数列 solution = new _10_斐波那契数列();
        System.out.println("n= 0, result=" + solution.Fibonacci2(0));
        System.out.println("n= 1, result=" + solution.Fibonacci2(1));
        System.out.println("n= 5, result=" + solution.Fibonacci2(5));
    }

}
