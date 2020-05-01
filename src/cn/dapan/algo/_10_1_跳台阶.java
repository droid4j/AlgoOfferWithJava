package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/1
 * @Version 1.0
 */
public class _10_1_跳台阶 {

    /*
    +---------------------------------------------+-----------------------+
    ｜      ｜      ｜      ｜      ｜             ｜      ｜      ｜       ｜
    ｜  1   ｜  2   ｜  3   ｜  4   ｜     。。。   ｜  n-2 ｜  n-1 ｜   n   ｜
    ｜      ｜      ｜      ｜      ｜             ｜      ｜      ｜       ｜
    +---------------------------------------------+-----------------------+

    假如从 n 开始跳，只能有两种跳法：1. 跳一个台阶，2. 跳两个台阶
             +--
             |    1   f(n-1) ， 当青蛙一下子跳 1个 台阶时，还有 f(n-1) 种跳法
        f(n) |                                                              此时，n >= 3
             |    2   f(n-2) ， 当青蛙一下子跳 2个 台阶时，还有 f(n-2) 种跳法
             +--

        也就是说，当有 n 个台阶时，共有 n-1 种跳一个台阶的方法，和 n-2 种跳两个台阶的方法
        即: 当 n >= 3时，f(n) = f(n-1) + f(n-2)
            当 n = 2 时，f(2) = 2
            当 n = 1 时，f(1) = 1
     */

    public int JumpFloor(int target) {
       if (target < 1) {
           return 0;
       }

       if (target <= 2) {
           return target;
       }

       int ret = 0;
       int a = 1;
       int b = 2;
       for (int i = 3; i < target; i++) {
           ret = a + b;
           a = b;
           b = ret;
       }
       return ret;
    }
}
