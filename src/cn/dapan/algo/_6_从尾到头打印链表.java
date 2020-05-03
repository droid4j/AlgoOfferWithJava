package cn.dapan.algo;

import java.util.ArrayList;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/3
 * @Version 1.0
 */
public class _6_从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }

        ListNode cur = listNode;
        while (cur != null) {
            result.add(0, cur.val);
            cur = cur.next;
        }

        return result;

    }

    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {

        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            result.add(listNode.val);
        }

        return result;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);

        _6_从尾到头打印链表 solution = new _6_从尾到头打印链表();
        ArrayList<Integer> result = solution.printListFromTailToHead2(n1);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
