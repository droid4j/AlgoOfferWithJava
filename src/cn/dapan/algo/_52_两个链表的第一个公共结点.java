package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/4
 * @Version 1.0
 */
public class _52_两个链表的第一个公共结点 {

    /*
                +-------+--+      +-------+--+      +-------+--+      +-------+--+      +-------+--+
                |       |  |      |       |  |      |       |  |      |       |  |      |       |  |
     pHead1 --> |   1   |  |----->|   2   |  |----->|   3   |  |----->|   4   |  |----->|   5   |  |-----> NULL
                |       |  |      |       |  |      |       |  |      |       |  |      |       |  |
                +-------+--+      +-------+--+      +-------+--+      +-------+--+      +-------+--+


                                                    +-------+--+      +-------+--+      +-------+--+
                                                    |       |  |      |       |  |      |       |  |
                                          pHead2 -->|   7   |  |----->|   4   |  |----->|   5   |  |-----> NULL
                                                    |       |  |      |       |  |      |       |  |
                                                    +-------+--+      +-------+--+      +-------+--+

        解: 第一步: 先计算两个链表长度，长的那个先走，直到与短的一致为止；
            第二步: 一起走，边走边对比，遇到一样的，就是找到第一个公共结点了。
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int p1Length = getLength(pHead1);
        int p2Length = getLength(pHead2);

        if (p1Length < p2Length) {
            pHead2 = walk(pHead2, p2Length - p1Length);
        } else {
            pHead1 = walk(pHead1, p1Length - p2Length);
        }

        while (pHead1 != null) {
            if (pHead1 == pHead2) return pHead1;  // 两个指针相等，表示找到第一个公共结点
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    private ListNode walk(ListNode head, int len) {
        while (len > 0) {
            head = head.next;
            len--;
        }
        return head;
    }

    private int getLength(ListNode pHead) {
        if (pHead == null) return 0;
        int sum = 0;
        while (pHead != null) {
            sum++;
            pHead = pHead.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p11 = new ListNode(2);
        ListNode p12 = new ListNode(3);
        ListNode p13 = new ListNode(4);
        ListNode p14 = new ListNode(5);
        p1.next = p11;
        p11.next = p12;
        p12.next = p13;
        p13.next = p14;

        ListNode p2 = new ListNode(7);
        p2.next = p13;
        p13.next = p14;

        _52_两个链表的第一个公共结点 solution = new _52_两个链表的第一个公共结点();
        ListNode listNode = solution.FindFirstCommonNode(p1, p2);
        System.out.println("第一个公共结点是：" + listNode.val);
    }

}
