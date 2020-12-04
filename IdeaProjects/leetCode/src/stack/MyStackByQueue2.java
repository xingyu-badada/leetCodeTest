package stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackByQueue2 {


    Queue<Integer> queue = new LinkedList<>();


    /**
     * Push element x onto stack.
     * 进栈
     */
    public void push(int x) {
        queue.add(x);
        //把对头元素那出来，放到队尾，颠倒size-1次
        int size = queue.size();
        while (size > 1) {
            int tail = queue.poll();
            queue.offer(tail);
            size--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

}
