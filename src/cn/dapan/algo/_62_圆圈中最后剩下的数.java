package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/4
 * @Version 1.0
 */
public class _62_圆圈中最后剩下的数 {

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        // 约瑟夫环问题，用环形链表模拟圆圈
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = head;

        int k = 0;
         while (node.next != node) {
             if (++k == m) {
                 System.out.println(node.next.val + " 出局");
                 node.next = node.next.next; // 出局
                 k = 0;
             } else {
                 node = node.next;
             }
         }
         return node.val;
    }

    public static void main(String[] args) {
        _62_圆圈中最后剩下的数 solution = new _62_圆圈中最后剩下的数();
        int result = solution.LastRemaining_Solution(5, 3);
        System.out.println(result);
    }
}
