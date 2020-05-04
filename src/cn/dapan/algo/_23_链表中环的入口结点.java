package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/4
 * @Version 1.0
 */
public class _23_链表中环的入口结点 {


    /**
     * 思路：1.判断链表中有环 -> 2.得到环中结点的数目 -> 3.找到环中的入口结点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        // 1.判断链表中有环
        ListNode fast = pHead, slow = pHead;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return null;
        } else {
            // 有环，得到环中结点的数目
            int n = 1;
            fast = fast.next;
            while (slow != fast) {
                fast = fast.next;
                n ++;
            }

            // 找到环中的入口结点
            fast = slow = pHead;
            for (int i = 0; i < n; i++) {
                fast = fast.next; // 先走n步
            }
            while (slow != fast) { // 再次相遇，就是入口结点
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        _23_链表中环的入口结点 solution = new _23_链表中环的入口结点();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;

        ListNode listNode = solution.EntryNodeOfLoop(n1);
        System.out.println(listNode.val);
    }
}
