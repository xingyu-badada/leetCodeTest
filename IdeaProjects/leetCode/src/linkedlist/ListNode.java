package linkedlist;

public class ListNode {
    //数据
    int val;
    //下一个节点的引用
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    //数组转化成链表
    public static ListNode arrayToListNode(int[] arr) {
        //如果数组长度为0，直接返回null
        if (arr.length == 0) return null;
        //生成链表的根节点
        ListNode root = new ListNode(arr[0]);
        //节点的前一个就是根节点
        ListNode pre = root;
        for (int i = 1; i < arr.length; i++) {
            //创建一个新节点，新节点中的值就是数组每次循环得到的值。
            ListNode node = new ListNode(arr[i]);
            //创建连接关系。
            //上一个节点的下一个，就是当前节点。
            pre.next = node;
            //更新pre为当前节点，下一个要处理的节点。
            pre = node;
        }
        return root;
    }

    //打印链表方法
    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("-->");
            }
            head = head.next;
        }
    }

    //pos代表尾节点指向，链表中某个节点的索引位置(环的入口)
    public static void toCycle(ListNode node, int pos) {
        //遍历，通过pos找到入口对应的节点 记录下来
        //遍历到尾节点时，设置为其next引用

        //记录遍历的位置
        int count = 0;
        //环形节点为空。
        ListNode cycleNode = null;
        while (true) {
            //判断是否是入口节点。
            if (count == pos) {
                //当前节点就是换入口节点。
                cycleNode = node;
            }
            //判断是否是尾节点。
            if (node.next == null) {
                //下个节点就是环形节点，相当于套了一个环
                node.next = cycleNode;
                return;
            }
            //当前节点是下一个节点
            node = node.next;
            //记录位置索引后移一位。
            count++;
        }
    }

}
