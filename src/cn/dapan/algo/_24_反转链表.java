package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/3
 * @Version 1.0
 */
public class _24_反转链表 {


    /*
                +-------+--+      +-------+--+      +-------+--+      +-------+--+      +-------+--+
                |       |  |      |       |  |      |       |  |      |       |  |      |       |  |
       head --> |   1   |  |----->|   2   |  |----->|   3   |  |----->|   4   |  |----->|   5   |  |-----> NULL
                |       |  |      |       |  |      |       |  |      |       |  |      |       |  |
                +-------+--+      +-------+--+      +-------+--+      +-------+--+      +-------+--+


      >>> 解：

          <1> 创建三个指针，prev, cur, next
          分别指向：
          prev = head
          cur = prev.next
          next = cur.next
          代码如下：
            ---------------------------
              ListNode prev = head;
              ListNode cur = head.next;
              ListNode next = cur.next;
            ---------------------------


                    prev              cur               next
                     |                 |                 |
                     V                 V                 V
                +-------+--+      +-------+--+      +-------+--+      +-------+--+      +-------+--+
                |       |  |      |       |  |      |       |  |      |       |  |      |       |  |
       head --> |   1   |  |----->|   2   |  |----->|   3   |  |----->|   4   |  |----->|   5   |  |-----> NULL
                |       |  |      |       |  |      |       |  |      |       |  |      |       |  |
                +-------+--+      +-------+--+      +-------+--+      +-------+--+      +-------+--+



          <2> 打断 prev 与 cur 之间的联系
          代码如下：
            ---------------------------
              prev.next = null;
            ---------------------------

                    prev              cur               next
                     |                 |                 |
                     V                 V                 V
                +-------+--+      +-------+--+      +-------+--+      +-------+--+      +-------+--+
                |       |  |      |       |  |      |       |  |      |       |  |      |       |  |
       head --> |   1   |  |      |   2   |  |----->|   3   |  |----->|   4   |  |----->|   5   |  |-----> NULL
                |       |  |      |       |  |      |       |  |      |       |  |      |       |  |
                +-------+--+      +-------+--+      +-------+--+      +-------+--+      +-------+--+



          <3> 进入 while 循环
          反转 cur 与 prev 之间的关系，cur的下一个结点指向prev
          代码如下：
            ---------------------------
              cur.next = prev;
            ---------------------------

                    prev              cur               next
                     |                 |                 |
                     V                 V                 V
                +-------+--+      +-------+--+      +-------+--+      +-------+--+      +-------+--+
                |       |  |      |       |  |      |       |  |      |       |  |      |       |  |
       head --> |   1   |  |      |   2   |  |--+   |   3   |  |----->|   4   |  |----->|   5   |  |-----> NULL
                |       |  |      |       |  |  |   |       |  |      |       |  |      |       |  |
                +-------+--+      +-------+--+  |   +-------+--+      +-------+--+      +-------+--+
                          ^                     |
                          |                     |
                          +---------------------+



          <4> 依次更新 prev、cur、next 三个指针
          更新顺序不能乱，否则无法进行下面的反转
          代码如下：
            ---------------------------
              prev = cur;
              cur = next;
              next = next.next;
            ---------------------------

                                      prev              cur               next
                                       |                 |                 |
                                       V                 V                 V
                +-------+--+      +-------+--+      +-------+--+      +-------+--+      +-------+--+
                |       |  |      |       |  |      |       |  |      |       |  |      |       |  |
       head --> |   1   |  |      |   2   |  |--+   |   3   |  |----->|   4   |  |----->|   5   |  |-----> NULL
                |       |  |      |       |  |  |   |       |  |      |       |  |      |       |  |
                +-------+--+      +-------+--+  |   +-------+--+      +-------+--+      +-------+--+
                          ^                     |
                          |                     |
                          +---------------------+



          <5> 进入下一轮 while 循环
          反转 cur 与 prev 之间的关系，cur的下一个结点指向prev
          代码如下：
            ---------------------------
              cur.next = prev;
            ---------------------------

                                            +---------------------+
                                            |                     |
                                      prev  |           cur       |       next
                                       |    |            |        |        |
                                       V    V            V        |        V
                +-------+--+      +-------+--+      +-------+--+  |   +-------+--+      +-------+--+
                |       |  |      |       |  |      |       |  |  |   |       |  |      |       |  |
       head --> |   1   |  |      |   2   |  |--+   |   3   |  |--+   |   4   |  |----->|   5   |  |-----> NULL
                |       |  |      |       |  |  |   |       |  |      |       |  |      |       |  |
                +-------+--+      +-------+--+  |   +-------+--+      +-------+--+      +-------+--+
                          ^                     |
                          |                     |
                          +---------------------+



          <6> 依次更新 prev、cur、next 三个指针
          * 更新顺序不能乱，否则无法进行下面的反转
          代码如下：
            ---------------------------
              prev = cur;
              cur = next;
              next = next.next;
            ---------------------------

                                            +---------------------+
                                            |                     |
                                            |           prev      |       cur               next
                                            |            |        |        |                 |
                                            V            V        |        V                 V
                +-------+--+      +-------+--+      +-------+--+  |   +-------+--+      +-------+--+
                |       |  |      |       |  |      |       |  |  |   |       |  |      |       |  |
       head --> |   1   |  |      |   2   |  |--+   |   3   |  |--+   |   4   |  |----->|   5   |  |-----> NULL
                |       |  |      |       |  |  |   |       |  |      |       |  |      |       |  |
                +-------+--+      +-------+--+  |   +-------+--+      +-------+--+      +-------+--+
                          ^                     |
                          |                     |
                          +---------------------+



          <7> 进入下一轮 while 循环
          反转 cur 与 prev 之间的关系，cur的下一个结点指向prev
          代码如下：
            ---------------------------
              cur.next = prev;
            ---------------------------

                                            +---------------------+
                                            |                     |
                                            |           prev      |       cur               next
                                            |            |        |        |                 |
                                            V            V        |        V                 V
                +-------+--+      +-------+--+      +-------+--+  |   +-------+--+      +-------+--+
                |       |  |      |       |  |      |       |  |  |   |       |  |      |       |  |
       head --> |   1   |  |      |   2   |  |--+   |   3   |  |--+   |   4   |  |--+   |   5   |  |-----> NULL
                |       |  |      |       |  |  |   |       |  |      |       |  |  |   |       |  |
                +-------+--+      +-------+--+  |   +-------+--+      +-------+--+  |   +-------+--+
                          ^                     |             ^                     |
                          |                     |             |                     |
                          +---------------------+             +---------------------+



          <8> 依次更新 prev、cur、next 三个指针
          * 更新顺序不能乱，否则无法进行下面的反转
          代码如下：
            ---------------------------
              prev = cur;
              cur = next;
              next = next.next;
            ---------------------------

                                            +---------------------+
                                            |                     |
                                            |                     |       prev              cur            next
                                            |                     |        |                 |              |
                                            V                     |        V                 V              |
                +-------+--+      +-------+--+      +-------+--+  |   +-------+--+      +-------+--+        V
                |       |  |      |       |  |      |       |  |  |   |       |  |      |       |  |
       head --> |   1   |  |      |   2   |  |--+   |   3   |  |--+   |   4   |  |--+   |   5   |  |-----> NULL
                |       |  |      |       |  |  |   |       |  |      |       |  |  |   |       |  |
                +-------+--+      +-------+--+  |   +-------+--+      +-------+--+  |   +-------+--+
                          ^                     |             ^                     |
                          |                     |             |                     |
                          +---------------------+             +---------------------+



          <9> 进入下一轮 while 循环
          此时，next 指向null，无法进入循环体，执行  while 之后的语句
          代码如下：
            ---------------------------
              cur.next = prev;
            ---------------------------

                                            +---------------------+             +---------------------+
                                            |                     |             |                     |
                                            |                     |       prev  |           cur       |    next
                                            |                     |        |    |            |        |     |
                                            V                     |        V    V            V        |     |
                +-------+--+      +-------+--+      +-------+--+  |   +-------+--+      +-------+--+  |     V
                |       |  |      |       |  |      |       |  |  |   |       |  |      |       |  |  |
       head --> |   1   |  |      |   2   |  |--+   |   3   |  |--+   |   4   |  |--+   |   5   |  |--+    NULL
                |       |  |      |       |  |  |   |       |  |      |       |  |  |   |       |  |
                +-------+--+      +-------+--+  |   +-------+--+      +-------+--+  |   +-------+--+
                          ^                     |             ^                     |
                          |                     |             |                     |
                          +---------------------+             +---------------------+

          <9> 结束
          至此，单链表反转结束，cur 指向新链表的头结点，返回即可。

     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = cur.next;

        prev.next = null;

        while (next != null) {
            cur.next = prev;

            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }

    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head.next;
        ListNode next = cur.next;

        head.next = null;

        while (next != null) {
            cur.next = head;

            head = cur;
            cur = next;
            next = next.next;
        }
        cur.next = head;
        return cur;
    }

    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode ReverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = ReverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        _24_反转链表 solution = new _24_反转链表();
        ListNode listNode = solution.ReverseList3(n1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
