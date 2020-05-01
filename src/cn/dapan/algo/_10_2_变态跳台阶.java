package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/1
 * @Version 1.0
 */
public class _10_2_变态跳台阶 {

    // f(n) = f(n-1) + f(n-2)+..+f(1)
    // f(n-1) = f(n-2) +..+f(1)
    // 当 n > 1， f(n) = 2*f(n-1)  // ---> 1
    // 当 n = 1， f(1) = 1         // ---> 2

    public int JumpFloorII1(int target) {
        return 1<<(target-1);
    }

    public int JumpFloorII(int target) {

        if (target == 1) { // 式1
            return 1;
        }

        int ret = 1;
        int prev = 1;
        for (int i = 2; i <= target; i++) { // 式2
            ret = 2 * prev;
            prev = ret;
        }
        return ret;
    }

}
