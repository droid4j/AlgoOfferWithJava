package cn.dapan.algo;

/**
 * @author droid4j@163.com
 * @Description: TODO
 * @Date 2020/5/4
 * @Version 1.0
 */
public class _35_复杂链表的复制 {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        // 1. 遍历链表，复制每个结点，如 复制结点A得到A1，将结点A1插入到结点A之后
        RandomListNode cur = pHead;
        while (cur != null) {
            // 创建 A' 结点
            RandomListNode copyNode = new RandomListNode(cur.label);
            RandomListNode nextNode = cur.next;
            cur.next = copyNode;
            copyNode.next = nextNode;
            cur = nextNode;
        }

        // 2. 重新遍历链表，复制老结点的随机指针给新结点，如：A1.random = A.random.next
        cur = pHead;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        // 3. 拆分链表，将链表分为原链表和复制后的链表
        cur = pHead;
        RandomListNode cloneHead = pHead.next;
        while (cur != null) {
            RandomListNode cloneNode = cur.next;
            cur.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            cur = cur.next;
        }

        return cloneHead;
    }


    /*
                                           +-----------------------------------+
                                           |                                   |
                         +-----------------------------------+                 |
                         |                 |                 |                 |
                         |                 V                 V                 |
                +-------+--+      +-------+--+      +-------+--+      +-------+--+
                |       |  |      |       |  |      |       |  |      |       |  |
       head --> |   1   |  |----->|   2   |  |----->|   3   |  |----->|   4   |  |-----> NULL
                |       |  |   +->|       |  |      |       |  |      |       |  |
                +-------+--+   |  +-------+--+      +-------+--+      +-------+--+
                               |           |                  |                 ^
                               |           |                  |                 |
                               +-----------+                  +-----------------+
     */
    public static void main(String[] args) {
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        n1.next = n2;
        n1.random = n3;

        n2.next = n3;
        n2.random = n2;

        n3.next = n4;
        n3.random = n4;
        n4.random = n2;

        _35_复杂链表的复制 solution = new _35_复杂链表的复制();
        RandomListNode newNode = solution.Clone(n1);
        while (newNode != null) {
            System.out.println(newNode.label + ", " + newNode.random.label);
            newNode = newNode.next;
        }
    }
}
