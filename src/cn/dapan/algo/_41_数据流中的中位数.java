package cn.dapan.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/8
 * @Version 1.0
 */
public class _41_数据流中的中位数 {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }); // 中位数的左区间 > 大顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 中位数的右区间 > 小顶堆
    private int sum = 0; // 数据流中个数

    public void Insert(Integer num) {
        if (sum % 2 == 0) {
            // 当两个元素个数一样的时候，此时新增一个元素，放入大顶堆
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int max = maxHeap.poll();
            int min = minHeap.poll();
            maxHeap.add(min);
            minHeap.add(max);
        }
        sum++;
    }

    public Double GetMedian() {
        if (sum % 2 == 1) {
            return Double.valueOf(maxHeap.peek());
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        _41_数据流中的中位数 solution = new _41_数据流中的中位数();
        int[] array = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i : array) {
            solution.Insert(i);
            System.out.println(solution.GetMedian());
        }
    }
}
