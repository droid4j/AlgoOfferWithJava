package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/5
 * @Version 1.0
 */
public class _15_二进制中1的个数 {

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            System.out.println(n);
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        _15_二进制中1的个数 solution = new _15_二进制中1的个数();
        System.out.println("结果：" + solution.NumberOf1(11));
    }
}
