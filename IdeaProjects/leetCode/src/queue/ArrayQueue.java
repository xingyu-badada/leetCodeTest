package queue;

public class ArrayQueue {

    //最大容量
    int maxCapacity;
    //声明头尾指针
    int head;
    int tail;
    //创建一个整数类型的数组
    //存储元素
    int[] arr;

    //初始化一个队列
    public ArrayQueue(int maxCapacity) {
        //创建一个最大容量的数组
        arr = new int[maxCapacity];
        maxCapacity = maxCapacity;
        //头尾指针的位置。
        head = 0;
        tail = 0;
    }

    //判断列表容器中是否已经满了。
    public boolean isFull() {
        //尾指针的位置，指向最大容量，说明已经满了。
        return tail == maxCapacity;
    }

    public void add(int n) {
        //将添加的值，放入数组中，尾指针的位置。
        if (!isFull()) {
            arr[tail] = n;
        }
    }

    //判断是否为空，
    public boolean isEmpty() {
        //头指针和尾指针重合了，队列长度为0；
        return head == tail;
    }

    public int get() {
        //如果为空，直接返回-1；
        if (isEmpty()) return -1;
        //取出的元素，就是数组中头指针对应的值
        int result = arr[head];
        //头指针的值被取走了，头指针就要向后移动一个位置
        //使得第二个值变为头元素。
        head++;
        return result;
    }
}
