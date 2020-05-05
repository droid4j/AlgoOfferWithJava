package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/5
 * @Version 1.0
 */
public class _49_丑数 {

    public int GetUglyNumber_Solution(int index) {
        if (index < 1) return 0;

        int p2 = 0, p3 = 0, p5 = 0;

        int[] result = new int[index];
        result[0] = 1;
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            if (result[i] == result[p2] * 2) p2++;
            if (result[i] == result[p3] * 3) p3++;
            if (result[i] == result[p5] * 5) p5++;
        }

        return result[index - 1];
    }

    public static void main(String[] args) {
        _49_丑数 solution = new _49_丑数();
        System.out.println(solution.GetUglyNumber_Solution(5));
    }
}
