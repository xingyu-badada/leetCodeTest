package stack;

import java.util.Stack;

public class MinStack2 {

    //数据栈
    Stack<Integer> dataStack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        //如果新元素使最小值发生变化，则会存储两个值，（原来的最小值，当前的最小值）
        if (min >= x) {
            //如果栈为空  说明是第一个元素，此时一定min>x
            if (!dataStack.isEmpty()) {
                dataStack.push(min);
            }
            //最小值重新赋值
            min = x;
        }
        dataStack.push(x);
    }

    public void pop() {
        if (dataStack.isEmpty()) return;
        if (dataStack.size()==1){
            min = Integer.MAX_VALUE;
        }else if (min == dataStack.peek()){
            dataStack.pop();
            min = dataStack.peek();
        }
        //如果一处的不是最小值，直接pop
        //如果移除的是最小值，前面移除一次
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return min;
    }
}
