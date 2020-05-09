package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/9
 * @Version 1.0
 */
public class _42_连续子数组的最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0) {
            return -1;
        }

        int maxNum = array[0]; // 上一轮的最大值
        int tempNum = array[0]; // 当前最大值
        for (int i = 1; i < array.length; i++) {
            int item = array[i];
            if (tempNum + item < item) {
                tempNum = item;
            } else {
                tempNum += item;
            }

            if (maxNum < tempNum) { // 如果上一轮的小，就更新为当前的值
                maxNum = tempNum;
            }
        }
        return maxNum;
    }
}
