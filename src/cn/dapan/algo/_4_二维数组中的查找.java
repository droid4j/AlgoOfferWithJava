package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/2
 * @Version 1.0
 */
public class _4_二维数组中的查找 {

    /*
        1   2   3   4
        3   4   5   6
        4   6   8   10
        9   11  13  15

        假如要找的数小于4，那么肯定不在 4 的下方，应该往 4 的左边找
        假如要找的数大小4，那么肯定不在 4 的左边，应该往 4 的下边找

        分析：二维数组，左上角数据最小，右下角数据最大，根据这个顺序，我们从`右上角`开始遍历
        如果 target 小于 `右上角` 元素，那 target 肯定小于 `右上角` 元素所在列的所有元素；
        如果 target 大于 `右上角` 元素，那 target 肯定大于 `右上角` 元素所在行的所有元素；
     */
    public boolean Find(int target, int [][] array) {
        // 1. 边界检查
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        // 2. 右上角元素(row, col),
        // array[0][array[0].length-1]
        // row = 0
        // col = array[0].length -1
        int row = 0;
        int col = array[row].length - 1;
        while (row < array.length && col >= 0) {
            int value = array[row][col];
            if (target == value) {
                return true;
            } else if (target < value) { // 往前一列找
                col--;
            } else { // target > value，往下一行找
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {4, 6, 8, 10},
                {9, 11, 13, 15}
        };
        _4_二维数组中的查找 solution = new _4_二维数组中的查找();
        System.out.println(solution.Find(4, array));
        System.out.println(solution.Find(12, array));
    }
}
