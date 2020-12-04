package linkedlist;


/**
 *
 * 141. 环形链表
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class HasCycle {

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, -4};
        ListNode node = ListNode.arrayToListNode(arr);
        //加环操作。
        ListNode.toCycle(node,1);
        System.out.println(hasCycle(node));
    }

    public static boolean hasCycle(ListNode head) {
        //直接判断，如果头节点或者头节点的下一个节点为空，说明不是个环形节点。
        if (head == null || head.next == null) {
            return false;
        }
        //使用快慢指针来做是否是环形链表的判断
        //定义一个慢指针，一个快指针。
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            //因为快指针是一次走两步的，
            //所以如果快指针为空，或者快指针的下一个节点为空，说明不是环形链表
            if (fast == null || fast.next == null) {
                return false;
            }
            //满指针一次走一步。
            slow = slow.next;
            //快指针一次走两步。
            fast = fast.next.next;
            //如果慢指针和快指针相遇了，就说明是环形链表，就直接返回。
            if (slow == fast) return true;
        }
    }

}
