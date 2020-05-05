package cn.dapan.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/5
 * @Version 1.0
 */
public class _39_数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : array) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }

            if (map.get(item) > array.length >> 1) {
                return item;
            }
        }
        return 0;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        int times = 0;
        int result = 0;
        for (int item : array) {
            if (times == 0) {
                result = item;
                times++;
            } else {
                if (result == item) {
                    times++;
                } else {
                    times--;
                }
            }
        }

        if (times == 0) {
            return 0;
        } else {
            times = 0;
            for (int item : array) {
                if (item == result) {
                    times++;
                }
            }

            if (times > array.length >> 1) {
                return result;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        _39_数组中出现次数超过一半的数字 solution = new _39_数组中出现次数超过一半的数字();
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution.MoreThanHalfNum_Solution(array));
    }
}
