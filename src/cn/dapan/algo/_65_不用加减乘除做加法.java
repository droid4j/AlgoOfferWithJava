package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/5
 * @Version 1.0
 */
public class _65_不用加减乘除做加法 {

    public int Add(int num1,int num2) {
        int xor = 0;
        int and = 0;
        do {
            xor = num1 ^ num2; // 各位相加不考虑进位，也就是异或
            and = (num1 & num2) << 1; // 与操作，求进位
            num1 = xor;
            num2 = and;
        } while (and != 0); // 表示有进位，继续按位操作
        return xor;
    }

    public static void main(String[] args) {
        _65_不用加减乘除做加法 solution = new _65_不用加减乘除做加法();
        System.out.println(solution.Add(3, 2));
    }
}
