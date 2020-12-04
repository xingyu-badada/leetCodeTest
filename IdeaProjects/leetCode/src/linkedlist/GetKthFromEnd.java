package linkedlist;


/**
 * 单链表的定义
 * Definition for singly-linked list.
 * <p>
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 思路分析：
 */
public class GetKthFromEnd {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = ListNode.arrayToListNode(arr);
        ListNode node = getKthFromEnd(head, 3);
        System.out.println(node.val);
    }

    //    解法
    //  先遍历出链表的总长度n，倒数第K个节点=从头遍历的第n-k+1个节点
    //方式一
    public static ListNode getKthFromEnd(ListNode head, int k) {
        //定义一个变量，用来记录链表的总长度。
        int n = 0;
        //定义一个零时的链表节点为头节点
        ListNode tmp = head;
        //如果头结点的下一个节点不为空，说明还有下一个节点。
        while (tmp.next != null) {
            //n++记录一下长度
            n++;
            //此时零时节点就是当前节点的下一个节点。
            tmp = tmp.next;
        }
        //将零时节点从先变成头节点
        tmp = head;
        //循环至n的总长度-参数所需的K个节点+1
        //因为n-k是索引，实际得到k位置的值需要+1
        for (int i = 0; i < n - k + 1; i++) {
            tmp = tmp.next;
        }
        //返回这个零时节点。
        return tmp;
    }

    //方式二
    /**
     * 先定义额外指针，找到整数第K个节点，然后两个指针同时向后移动，
     * 当快的指针到达链表的最后一个节点是，慢的指针，真好到达倒数第K个节点。
     * (相当于，慢的指针没组的K步，由快的指针帮忙走完了。)
     */
    public static ListNode getKthFromEnd1(ListNode head, int k) {
        //定义快慢指针
        ListNode slow = head;
        ListNode fast = head;
        //i从1开始，循环到要删除的k元素
        for (int i = 1; i < k; i++) {
            //将fast定位到K的的位置。
            fast = fast.next;
        }
        //fast.next为空，说明没有下一个节点了，就跳出循环了。
        while (fast.next != null) {
            //快慢指针都指向自己的下一个节点，当fast指针走到头，
            //说明slow就是现在要返回的节点
            slow = slow.next;
            fast = fast.next;
        }
        //slow的位置，就是到倒数第K个节点。
        return slow;
    }
}
