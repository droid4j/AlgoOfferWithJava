package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/4
 * @Version 1.0
 */
public class _25_合并两个排序的链表 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-1);
        ListNode dummyHead = temp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
        }

        if (list2 != null) {
            temp.next = list2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        ListNode n7 = new ListNode(7);
        ListNode n9 = new ListNode(9);
        n1.next = n3;
        n3.next = n5;
        n5.next = n7;
        n7.next = n9;

        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n6 = new ListNode(6);
        ListNode n8 = new ListNode(8);
        ListNode n10 = new ListNode(10);
        n2.next = n4;
        n4.next = n6;
        n6.next = n8;
        n8.next = n10;
        _25_合并两个排序的链表 solution = new _25_合并两个排序的链表();
        ListNode newNode = solution.Merge(n1, n2);
        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }

    }
}
