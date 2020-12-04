package queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 添加：
         * add：如果队列满了，add会抛出异常
         * offer：如果队列满了，offer会返回false。
         */
        //添加元素的方法
        queue.add(1);
        //推荐使用，offer方法更健壮。
        queue.offer(1);


        /**
         * 获取：
         * peek方法会返回null，推荐使用。
         * element方法会抛出异常。
         */
        //取出元素，分两种，
        queue.peek();
        queue.element();

        /**
         * 找到并取出
         * poll方法会返回null
         * remove会返回异常。
         */
        queue.poll();
        queue.remove();

    }
}
