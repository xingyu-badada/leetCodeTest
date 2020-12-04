package queue;


import java.time.temporal.ValueRange;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
public class MaxQueue {

    //存储整数类型的最大值
    LinkedList<Integer> queue;
    //原始队列
    LinkedList<Integer> max;

    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty())return -1;
        return max.peekFirst();
    }

    //取出队尾元素比较
    public void push_back(int value) {
        queue.offer(value);
        while (!max.isEmpty() && max.peekLast() < value) {
            max.pollLast();
        }
        max.add(value);
    }

    public int pop_front() {
        //如果删除的元素是最大值，那么从max队列中同事删掉
        if (!max.isEmpty() && queue.peekFirst().equals(max.peekFirst())) {
            max.pollFirst();
        }
        if (queue.isEmpty()) return -1;
        return queue.poll();
    }
}
