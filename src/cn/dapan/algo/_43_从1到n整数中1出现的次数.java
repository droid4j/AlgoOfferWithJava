package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/5
 * @Version 1.0
 */
public class _43_从1到n整数中1出现的次数 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m; int b = n % m;
            cnt += (a + 8) / 10 * m  + (a % 10 == 1 ? b + 1: 0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        _43_从1到n整数中1出现的次数 solution = new _43_从1到n整数中1出现的次数();
        System.out.println(solution.NumberOf1Between1AndN_Solution(216));
    }
}
