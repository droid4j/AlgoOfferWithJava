package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/2
 * @Version 1.0
 */
public class _21_调整数组顺序使奇数位于偶数前面 {

    public void reOrderArray(int [] array) {
        int[] ret = new int[array.length]; // 以空间换时间

        for (int i = 0; i < array.length; i++) {
            ret[i] = array[i];
        }

        int index = 0;
        for (int i : ret) {
            if (i % 2 != 0) { // 奇数
                array[index++] = i;
            }
        }

        for (int i : ret) {
            if (i % 2 == 0) { // 偶数
                array[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        _21_调整数组顺序使奇数位于偶数前面 solution = new _21_调整数组顺序使奇数位于偶数前面();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        solution.reOrderArray(array);
        for (int i : array) {
            System.out.print(i + ", ");
        }
    }
}
