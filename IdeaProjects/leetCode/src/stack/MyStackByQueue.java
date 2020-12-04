package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 */
public class MyStackByQueue {


    //存储数据的队列
    Queue<Integer> dateQueue = new LinkedList<>();
    //零时队列
    Queue<Integer> tmpQueue = new LinkedList<>();
    //记录栈顶元素
    int top;


    /**
     * Initialize your data structure here.
     */
    public MyStackByQueue() {
    }

    /**
     * Push element x onto stack.
     * 进栈
     */
    public void push(int x) {
        dateQueue.add(x);
        top = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        //判断如果村粗的队列长度大于1，说明有值。
        while (dateQueue.size() > 1) {
            //top等于date中的元素
            top = dateQueue.poll();
            //将top存入零时队列中。
            tmpQueue.add(top);
        }
        //poll找到并取出。
        int num = dateQueue.poll();
        //将dateQueue的元素移动回去
        Queue tmp = dateQueue;
        dateQueue = tmpQueue;
        tmpQueue = tmp;
        return num;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return dateQueue.size() == 0;
    }
}
