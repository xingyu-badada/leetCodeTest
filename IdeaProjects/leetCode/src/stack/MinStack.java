package stack;

import java.util.Stack;

/**
 * 栈的最小值
 */
public class MinStack {
    //数据栈
    Stack<Integer> dataStack = new Stack<>();
    //存储最小值的额外栈
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        dataStack.push(x);
        //比较新元素 和minStack中栈顶元素(之前所有元素的最小值) 谁更小
        if (!minStack.isEmpty() && minStack.peek() <x){
            //如果栈顶元素更小，再存进栈一次
            minStack.push(minStack.peek());
        }else {
            minStack.push(x);
        }

    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
