package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/5
 * @Version 1.0
 */
public class _56_1_数组中只出现一次的数字 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if (array == null || array.length < 2) return;

        int twoNumXor = 0;
        for (int item : array) {
            if (twoNumXor == 0) {
                twoNumXor = item;
            } else {
                twoNumXor = twoNumXor ^ item;
            }
        }

        int count = 0;
        while (twoNumXor % 2 == 0) {
            twoNumXor = twoNumXor >> 1;
            count++;
        }

        int mark = 1 << count;

        int first = 0;
        int second = 0;
        for (int item : array) {
            if ((mark & item) == 0) {
                if (first == 0) {
                    first = item;
                } else {
                    first = first ^ item;
                }
            } else {
                if (second == 0) {
                    second = item;
                } else {
                    second = second ^ item;
                }
            }
        }
        num1[0] =first;
        num2[0] = second;
    }

    public static void main(String[] args) {
        _56_1_数组中只出现一次的数字 solution = new _56_1_数组中只出现一次的数字();
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] array1 = new int[1];
        int[] array2 = new int[1];
        solution.FindNumsAppearOnce(array, array1, array2);
        System.out.println(array1[0]);
        System.out.println(array2[0]);
    }
}
