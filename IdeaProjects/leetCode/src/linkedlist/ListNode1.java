package linkedlist;

public class ListNode1 {
    //数据
    String date;
    //下一个节点的引用
    ListNode1 next;

    public ListNode1(String date) {
        this.date = date;
    }

    //数组转化成链表
    public static ListNode1 arrayToListNode(String[] arr) {
        //如果数组长度为0，直接返回null
        if (arr.length == 0) return null;
        //生成链表的根节点
        ListNode1 root = new ListNode1(arr[0]);
        //节点的前一个就是根节点
        ListNode1 pre = root;
        for (int i = 1; i < arr.length; i++) {
            //创建一个新节点，新节点中的值就是数组每次循环得到的值。
            ListNode1 node = new ListNode1(arr[i]);
            //创建连接关系。
            //上一个节点的下一个，就是当前节点。
            pre.next = node;
            //更新pre为当前节点，下一个要处理的节点。
            pre = node;
        }
        return root;
    }

    public static void main(String[] args) {
        String[] arr = {"王者荣耀","和平精英","开心消消乐","斗地主"};
        ListNode1 node = arrayToListNode(arr);
        System.out.println();
    }
}
