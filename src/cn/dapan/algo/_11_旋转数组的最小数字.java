package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/2
 * @Version 1.0
 */
public class _11_旋转数组的最小数字 {

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        // 二分查找变体
        int left = 0;
        int right = array.length - 1;
        while (left < right) {

            // 子数组是非递减的数组
            if (array[left] < array[right]) {
                return array[left];
            }

            int mid = (left + right) >> 1;
            if (array[mid] > array[left]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                left++;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        _11_旋转数组的最小数字 solution = new _11_旋转数组的最小数字();
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(solution.minNumberInRotateArray(array));

        array = new int[]{1, 0, 1, 1, 1};
        System.out.println(solution.minNumberInRotateArray(array));
    }
}
