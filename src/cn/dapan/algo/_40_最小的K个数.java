package cn.dapan.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/8
 * @Version 1.0
 */
public class _40_最小的K个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int len = input.length;
        if (k > len || k == 0) {
            return result;
        }

        int[] maxHeap = new int[k];
        for (int i = 0; i < len; i++) {
            if (i < k) {
                createMaxHeap(maxHeap, i, input[i]);
            } else {
                adjustMaxHeap(maxHeap, input[i]);
            }
        }

        for (int i : maxHeap) {
            result.add(i);
        }

        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : o1 < o2 ? -1 : 0;
            }
        });
        return result;
    }

    private void createMaxHeap(int[] maxHeap, int index, int item) {
        maxHeap[index] = item; // 存到最大堆末尾

        swapUp(maxHeap, index);
    }

    private void swapUp(int[] maxHeap, int size) {
        int k = size; // maxHeap.length
        int parent = parent(k);
        int temp = 0;
        // k 不能为根节点，并且k节点的值要比父节点的大
        while (k > 0 && maxHeap[parent] < maxHeap[k]) {
            temp = maxHeap[parent];
            maxHeap[parent] = maxHeap[k];
            maxHeap[k] = temp;

            k = parent(k);
        }
    }

    private int parent(int k) {
        return (k - 1) >> 1;
    }

    private void adjustMaxHeap(int[] maxHeap, int item) {
        if (maxHeap[0] > item) {
            maxHeap[0] = item;
        }

        for (int i = maxHeap.length - 1; i >= 0; i--) {
            siftDown(maxHeap, i);
        }
    }

    private void siftDown(int[] maxHeap, int k) {
        while (leftChild(k) < maxHeap.length) {
            int j = leftChild(k);
            // 右值存在，并且大于左值
            if (j + 1 < maxHeap.length && maxHeap[j] < maxHeap[j + 1]) {
                j = rightChild(k);
            }
            if (maxHeap[k] >= maxHeap[j]) {
                break;
            }
            int temp = maxHeap[k];
            maxHeap[k] = maxHeap[j];
            maxHeap[j] = temp;
            k = j;
        }
    }

    private int leftChild(int k) {
        return k * 2 + 1;
    }

    private int rightChild(int k) {
        return k * 2 + 2;
    }

    // 借助 PriorityQueue
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int len = input.length;
        if (k > len || k == 0) {
            return result;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < len; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }

        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }

    public static void main(String[] args) {
        _40_最小的K个数 solution = new _40_最小的K个数();
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = solution.GetLeastNumbers_Solution1(input, 4);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
