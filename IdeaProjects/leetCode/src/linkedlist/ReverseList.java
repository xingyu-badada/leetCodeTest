package linkedlist;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ReverseList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.arrayToListNode(arr);
        ListNode result = reverseList(head);
        ListNode.print(result);
    }


    public static ListNode reverseList(ListNode head) {
        //节点的上一个为空
        ListNode pre = null;
        //当前节点是头结点。
        ListNode cur = head;
        //如果当前节点不为空，就继续循环
        while (cur != null) {
            //防止节点丢失，所以创建一个零时节点
            //零时节点就是当前节点的下一个。
            ListNode tmp = cur.next;
            //变更指针指向，当前节点的下一个，就是前一个节点。
            cur.next = pre;
            //前一个节点就是当前节点。
            pre = cur;
            //零时节点就是当前节点。
            cur = tmp;
        }
        //返回前一个节点。
        return pre;
    }
}
