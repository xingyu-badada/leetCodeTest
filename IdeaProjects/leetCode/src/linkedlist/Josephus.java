package linkedlist;


/**
 * 约瑟夫环问题
 */
public class Josephus {

    //环形链表解决
    public static int josephus(int n, int m) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        //将数组转化成环形链表
        ListNode node = ListNode.arrayToListNode(arr);
        ListNode.toCycle(node, 0);
        int cnt = 1;
        while (true) {
            if (cnt == m - 1) {
                node.next = node.next.next;
                cnt = 0;
            }
            node = node.next;
            cnt++;
            if (node.next == node) return node.val;
        }
    }

    //数组实现
    public static int josephus1(int n, int m) {
        //数组记录，初始值是0，使用-1代表当前元素，死掉
        int[] people = new int[n];
        //人的索引
        int index = -1;
        //报数
        int cnt = 0;
        //剩余人数
        int remain = n;
        while (remain > 0) {
            index++;
            //到达数组末端，重新从头遍历
            if (index >= n) index = 0;
            //如果此人死掉，跳过，继续报数
            if (people[index] == -1) {
                continue;
            }
            //报数到m  将index对应位置的元素 置为-1(尸体)
            if (cnt == m) {
                people[index] = -1;
                cnt = 0;
                remain--;
            }
            cnt++;
        }
        return index;
    }
}
